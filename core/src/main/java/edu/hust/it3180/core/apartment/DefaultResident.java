package edu.hust.it3180.core.apartment;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import edu.hust.it3180.resident.Resident;

public class DefaultResident implements Resident {
    public static DefaultResident asDefaultImpl(Resident rs) {
        if (rs instanceof DefaultResident drs) {
            return drs;
        } else {
            return new DefaultResident(rs.name(), rs.phone(), rs.email(), rs.citizenIdentificationCard());
        }
    }
    
    private String name;
    private String phone;
    private String email;
    private String cicLink;
    
    public DefaultResident(String name, Optional<String> phone, Optional<String> email, Optional<URI> cicLink) {
        this.name = name;
        this.phone = phone.orElse(null);
        this.email = email.orElse(null);
        this.cicLink = cicLink.map(uri -> uri.toString()).orElse(null);
    }
    
    @Override
    public String name() {
        return name;
    }
    
    @Override
    public Optional<String> phone() {
        return Optional.ofNullable(phone);
    }
    
    @Override
    public Optional<String> email() {
        return Optional.ofNullable(email);
    }
    
    @Override
    public Optional<URI> citizenIdentificationCard() {
        URI uri = null;
        try {
            uri = new URI(cicLink);
            return Optional.of(uri);
        } catch (URISyntaxException e) {
            return Optional.empty();
        }
    }
    
}
