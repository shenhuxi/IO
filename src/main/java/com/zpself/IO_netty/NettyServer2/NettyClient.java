package com.zpself.IO_netty.NettyServer2;

import java.nio.charset.Charset;
import java.util.Date;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        bootstrap.group(workerGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) {
                nioSocketChannel.pipeline().addLast(new FirstClientHandler());
            }
        }).connect("127.0.0.1", 8000);
    }
}

class FirstClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.println(new Date() + ": 客户端写出数据");
        ByteBuf buffer = getByteBuf(channelHandlerContext);
        channelHandlerContext.channel().writeAndFlush(buffer);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBuf = channelHandlerContext.alloc().buffer();
        byte[] bs = "Hello Leif".getBytes(Charset.forName("utf-8"));
        byteBuf.writeBytes(bs);
        return byteBuf;
    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object message) throws Exception {
        ByteBuf byteBuf = (ByteBuf) message;
        System.out.println(new Date() + ": 客户端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
    }
}