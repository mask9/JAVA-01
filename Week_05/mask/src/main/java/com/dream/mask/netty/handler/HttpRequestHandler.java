package com.dream.mask.netty.handler;

import com.dream.mask.netty.filter.HeaderHttpRequestFilter;
import com.dream.mask.netty.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;

import java.util.List;

public class HttpRequestHandler extends ChannelInboundHandlerAdapter {
    private List<String> handlerList;
    
    private HttpResponseHandler handler;
    
    private HttpRequestFilter filter = new HeaderHttpRequestFilter();
    
    public HttpRequestHandler(List<String> handlerList) {
        handler = new HttpResponseHandler(handlerList);
        this.handlerList = handlerList;
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            handler.handle(fullRequest, ctx, filter);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
    
}
