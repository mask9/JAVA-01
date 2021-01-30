package com.dream.mask.netty.router;

import java.util.List;

public interface HttpEndpointRouter {
    
    String route(List<String> endpoints);
}
