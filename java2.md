# java 第三阶段

## 网络编程

### 相关概念

#### ip地址

1. 概念：用于唯一标识网络中的每台计算机/生机

2. 查看ip地址：ipconfig

3. ip地址的表示形式：点分十进制x.xxx.xx.xx

4. 每一个十进制数的范围：0~255

5. ip地址的组成=网络地址+主机地址，比如：192.168.16.69

6. iPv6是互联网工程任务组设计的用于替代PV4的下一代P协议，其地址数量号称可以
   为全世界的每一粒沙子编上一个地址。

7. 由于1PV4最大的问题在于网络地址资源有限，严重制约了互联网的应用和发展。IPV6
   的使用，不仅能解决网络地址资源数量的问题，而且也解决了多种接入设备连入互联
   的障碍

[【零基础 快速学Java】韩顺平 零基础30天学会Java_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1fh411y7R8?p=663&spm_id_from=pageDriver)

### InetAddress 类

1. 获取本机InetAddress对像getLocalHost

2. 根据指定主机名/域名获取ip地址对象getByName

3. 获取InetAddress对像的主机名getHostName

4. 获取InetAddress对象的地t址getHostAddress

```java
public class UseInetAddress{
   public static void main(String[] args) throws UnknownHostException {
//        获取本机的 InetAddress 对象
      InetAddress localHost = InetAddress.getLocalHost();
      System.out.println(localHost);

//        根据指定主机名，获取 InetAddress 对象
      InetAddress byName = InetAddress.getByName("DESKTOP-I9EJ2FT");
      System.out.println("host1="+byName);

//        根据指定域名，获取 InetAddress 对象
      InetAddress byName1 = InetAddress.getByName("www.baidu.com");
      System.out.println("baidu="+byName1);

//      根据 InetAddress 对象，获取 ip 地址
      String hostAddress = byName1.getHostAddress();
      System.out.println("hostAddress="+hostAddress);

//        获取主机名
      String hostName = byName1.getHostName();
      System.out.println("hostName="+hostName);
   }
}
```

### Socket 套接字

基本介绍

1. 套接字(Socket)开发网络应用程序被广泛采用，以至于成为事实上的标准。

2. 通信的两端都要有Socket,是两台机器间通信的端点

3. 网络通信其实就是Socket间的通信。

4. Socket:允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输。

5. 一般主动发起通信的应用程序属客户端，等待通信请求的为服务端

![socket](java2.assets/套接字.png)

> 字节流

服务端

```java
public class SocketTCPServer {
    public static void main(String[] args) throws IOException {
//        在本机的 9999 端口监听，等待连接
//        细节：要求 9999 端口没有被占用
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("监听 9999 端口，等待连接。。。");
//        没有连接 9999 端口时，会阻塞
//        如果有连接，会返回一个 Socket 对象
        Socket accept = serverSocket.accept();
        System.out.println("服务端 socket=" + accept.getClass());

        InputStream inputStream = accept.getInputStream();
        byte[] data = new byte[1024];
        int len;
        while ((len = inputStream.read(data)) != -1)
            System.out.println(new String(data,0,len));
        
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello Client".getBytes());
        socket.shutdownOutput();  // 结束标记

        inputStream.close();
        outputStream.close();
        accept.close();
        serverSocket.close();
    }
}
```

客户端

```java
public class SocketTCPClient {
    public static void main(String[] args) throws IOException {
//        连接服务器(ip,端口)
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
//        连接上后，生成 Socket
//        通过 socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("hello world".getBytes());
        socket.shutdownOutput(); // 结束标记

        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len;
        while ((len = inputStream.read(buf)) != -1)
            System.out.println(new String(buf,0,len));

        inputStream.close();
        outputStream.close(); // 关闭流
        socket.close();       // 关闭 socket
        System.out.println("客户端退出");
    }
}
```

> 字符流

服务端

```java
public class SocketTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = bufferedReader.readLine();
        System.out.println(line);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("Hello Client");
        bufferedWriter.newLine();  // 插入一个换行符
        bufferedWriter.flush();  // 使用字符流需要刷新，否则不会写入

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
```

客户端

```java
public class SocketTCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
//        转成 包装流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("Hello Server");

        bufferedWriter.newLine();  // 插入一个换行符
        bufferedWriter.flush();  // 使用字符流需要刷新，否则不会写入

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = bufferedReader.readLine();
        System.out.println(line);

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
```

告诉另一边“我说完了”  => writer.newLine( )

另一边  => reader.readLine( )

==一定要 flush==

> netstat 指令

1.netstat-an 可以查看当前主机网络情况，包括端▣监听情况和网络连接情况
2.netstat-an | more可以分页显示
3.要求在dos控制台下执行r

> ●TCP网络通讯不为人知的秘密
> 当客户端连接到服务端后，实际上客户端也是通过==一个端口==和服务端进行通讯的，这
> 个端口是TC/IP来分配的，是不确定的，是随机的。

### UDP

1. 类DatagramSocket和DatagramPacket[数据包/数据报]实现了基于UDP协议网络程序。

2. UDP数据报通过数据报套接字DatagramSocket发送和接收，系统==不保证==UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达。

3. DatagramPacket对象封装了UDP数据报，在数据报中包含了发送端的1P地址和端口号以及接收端的P地址和端口号。

4. UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和接收方的连接

>UDP说明：
>
>1. 没有明确的服务端和客户端，演变成数据的发送端和接收端
>
>2. 接收数据和发送数据是通过DatagramSocket对象完成
>
>3. 将数据封装到DatagramPacket对像/装包
>
>4. 当接收到DatagramPacket对象，需要进行拆包，取出数据
>
>5. DatagramSocket可以指定在哪个端口接收数据

UDP通信

```java
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
//        1.创建一个 DatagramSocket 对象, 在 9999 端口接收数据
        DatagramSocket socket = new DatagramSocket(9999);
//        2.构建一个 DatagramPacket 对象，准备接收数据
//        一个数据包最大 64k
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

//        3.调用接收方法，将 网络传输的 DatagramPacket 对象填充到 packet 对象
//        如果没有数据发送到本机 9999 端口，会阻塞
        System.out.println("接收端A在等待...");
        socket.receive(packet);

//        4.拆包 packet
        int length = packet.getLength();  // 实际的数据长度
        byte[] data = packet.getData();
        String str = new String(data,0,length);
        System.out.println(str);
        
//       回送
        data = "好的 明天见~".getBytes();
        packet =  new DatagramPacket(data,data.length, InetAddress.getLocalHost(),9998);
        socket.send(packet);


        socket.close();
        System.out.println("A端退出");

    }
}
```

```java
public class UDPReceiverB {
    public static void main(String[] args) throws IOException {
//        1.创建一个 DatagramSocket 对象, 在 9998 端口发送数据
        DatagramSocket socket = new DatagramSocket(9998);

//        2.将数据封装 到 DatagramPacket 对象
        byte[] data = "Hello 明天吃火锅".getBytes();
//        byte buf[], int length,
//        InetAddress address, int port
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        socket.send(packet);

//        接收 A 的回复
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        int length = packet.getLength();
        data = packet.getData();

        String s = new String(data, 0, length);
        System.out.println("B端收到" + s);

        socket.close();
        System.out.println("B端退出");
    }
}
```

多用户即时通信系统

