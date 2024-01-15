package edu.hust.it3180.core;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.money.MonetaryAmount;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.type.format.jackson.JacksonJsonFormatMapper;
import org.javamoney.moneta.FastMoney;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.module.SimpleModule;

import edu.hust.it3180.Apartment;
import edu.hust.it3180.api.BillingSystem;
import edu.hust.it3180.billing.fee.FeeFormula;
import edu.hust.it3180.core.apartment.DefaultApartment;
import edu.hust.it3180.core.apartment.DefaultApartmentPosition;
import edu.hust.it3180.core.apartment.DefaultContractStatus;
import edu.hust.it3180.core.billing.fee.OneTimeFee;

@SpringBootApplication
public class Bootstrap {
    public static final class RandomFeeFormula implements FeeFormula {
        private String description = "88000 VND Fee";
        
        public String getDescription() {
            return description;
        }
        
        public void setDescription(String description) {
            this.description = description;
        }
        
        @Override
        public MonetaryAmount calculate(Apartment apartment) {
            return FastMoney.of(88000, "VND");
        }
        
        @Override
        public Optional<LocalDate> deadline() {
            throw new UnsupportedOperationException("Unimplemented method 'deadline'");
        }
        
        @Override
        public MonetaryAmount fine(LocalDate paymentDate) {
            throw new UnsupportedOperationException("Unimplemented method 'fine'");
        }
        
        @Override
        public String description() {
            return description;
        }
    }

    @JsonDeserialize(as = RandomFeeFormula.class)
    interface FeeFormulaMixin {
    }
    
    @Bean
    public HibernatePropertiesCustomizer jsonFormatMapperCustomizer() {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        objectMapper.registerModule(
            new SimpleModule("Mixin module")
                .setMixInAnnotation(FeeFormula.class, FeeFormulaMixin.class));
        return properties -> properties
            .put(AvailableSettings.JSON_FORMAT_MAPPER, new JacksonJsonFormatMapper(objectMapper));
    }
    
    public static void main(String[] args) {
        new SpringApplicationBuilder(Bootstrap.class)
            .web(WebApplicationType.NONE)
            .run(args);
    }
    
    @Bean
    ApplicationRunner runner(BillingSystem system) {
        return (args) -> {
            DefaultApartment a = new DefaultApartment();
            a.setPosition(new DefaultApartmentPosition(List.of(1), "102", "102", "unknown"));
            DefaultContractStatus b = new DefaultContractStatus();
            b.setRecords(List.of());
            a.setStatus(b);
            system.register(a);
            system.applyFee(new OneTimeFee("One time fee 2", true, new RandomFeeFormula()), ap -> true);
            system.issueBills();
        };
    }
}
