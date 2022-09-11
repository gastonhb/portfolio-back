package com.portfolio.back.service;

import com.portfolio.back.model.SocialNetworkType;
import java.util.List;
import java.util.UUID;

public interface ISocialNetworkTypeService {
    
    public List<SocialNetworkType> list ();
    
    public SocialNetworkType create (SocialNetworkType socialNetworkType);
    
    public void delete (UUID id);
    
    public SocialNetworkType getById (UUID id);
    
    public SocialNetworkType update (SocialNetworkType socialNetworkType);
    
}
