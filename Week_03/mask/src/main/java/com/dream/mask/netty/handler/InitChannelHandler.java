package com.dream.mask.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.util.List;

public class InitChannelHandler extends ChannelInitializer<SocketChannel> {
    
    public InitChannelHandler(List<String> handlerList) {
        this.handlerList = handlerList;
    }
    
    private List<String> handlerList;
    
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        p.addLast(new HttpServerCodec());
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        p.addLast(new HttpRequestHandler(handlerList));
    }
}
