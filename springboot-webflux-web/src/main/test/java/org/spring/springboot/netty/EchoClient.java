package org.spring.springboot.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import static io.netty.handler.codec.http.HttpHeaders.Names.HOST;

public class EchoClient {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new ChannelHandler() {
                            @Override
                            public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {

                            }

                            @Override
                            public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {

                            }

                            @Override
                            public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

                            }
                        });
                    }
                });

        // Start the client.
        ChannelFuture f = null;
        try {
            f = b.connect(HOST, 8080).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Wait until the connection is closed.
        try {
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Shut down the event loop to terminate all threads.
        group.shutdownGracefully();
    }




}
