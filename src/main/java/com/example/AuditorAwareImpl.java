package com.example;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<Object> {



    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.AuditorAware#getCurrentAuditor()
     */
    @Override
    public String getCurrentAuditor() {
        return "aaaaaa";
    }
}
