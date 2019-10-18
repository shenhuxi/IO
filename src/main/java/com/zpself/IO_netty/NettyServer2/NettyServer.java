package com.zpself.IO_netty.NettyServer2;

import java.nio.charset.Charset;
import java.util.Date;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) {
                nioSocketChannel.pipeline().addLast(new FirstServerHandler());
            }
        }).bind(8000);
    }
}

class FirstServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object message) throws Exception {
        ByteBuf byteBufIn = (ByteBuf) message;
        System.out.println(new Date() + ": 服务端读到数据 -> " + byteBufIn.toString(Charset.forName("utf-8")));

        // 回复数据到客户端
        System.out.println(new Date() + ": 服务端写出数据");
        ByteBuf byteBufOut = getByteBuf(channelHandlerContext);
        channelHandlerContext.channel().writeAndFlush(byteBufOut);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext channelHandlerContext) {
        byte[] bs = "Hello World".getBytes(Charset.forName("utf-8"));
        ByteBuf byteBuf = channelHandlerContext.alloc().buffer();
        byteBuf.writeBytes(bs);
        return byteBuf;
    }
}