package leetcode;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {




    public void selector() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //设置为非阻塞方式
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(8080));
        //注册监听事件
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            //取得所有Key集合
            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();

            while (it.hasNext()){
                SelectionKey key = (SelectionKey) it.next();

                if((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT){
                    ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
                    //接受到服务端的请求
                    SocketChannel sc = ssChannel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ);
                    it.remove();
                }else if((key.readyOps()&SelectionKey.OP_READ) == SelectionKey.OP_READ){
                    SocketChannel sc = (SocketChannel) key.channel();
                    while (true){
                        buffer.clear();
                        //读取数据
                        int n = sc.read(buffer);
                        if(n<0){
                            break;
                        }
                        buffer.flip();
                    }
                    it.remove();
                }
            }
        }
    }


    public void partitionArray(int[] nums) {
        // write your code here
        for(int i=1;i<nums.length;i++){

        }
    }


}
