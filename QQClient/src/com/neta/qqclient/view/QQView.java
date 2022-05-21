package com.neta.qqclient.view;

import com.neta.qqclient.service.FileClientService;
import com.neta.qqclient.service.MessageClientService;
import com.neta.qqclient.service.UserClientService;
import com.neta.qqclient.utils.Utility;

/**
 * 客户端界面
 */
public class QQView {
    public static void main(String[] args) {
        new QQView().mainMenu();
    }

    private boolean loop = true; // 默认显示主菜单
    private String key = ""; // 获取用户输入
    private final UserClientService userClientService = new UserClientService();  // 用于登录/注册
    private final MessageClientService messageClientService = new MessageClientService();
    private final FileClientService fileClientService = new FileClientService();
    // 显示主菜单
    private void mainMenu(){

        while (loop){
            System.out.println("========欢迎登录网络通信系统========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");

            System.out.print("请输入你的选择:");
            key = Utility.readString(1);

//            根据输入处理
            switch (key){
                case "1":
                    System.out.print("请输入账号:");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密码:");
                    String pwd = Utility.readString(50);
//                  创建一个 user
                    if(userClientService.checkUser(userId,pwd)){
                        System.out.println("========欢迎用户"+userId+"========");
                        System.out.println("二级菜单");
                        while (loop){
                            System.out.println("========网络通信系统二级菜单"+userId+"========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 5 发送文件");
                            System.out.println("\t\t 9 退出系统");

                            System.out.print("请输入你的选择:");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    userClientService.olineFriendList();
                                    break;
                                case "2":
                                    System.out.print("请输入想对大家说的话:");
                                    String word = Utility.readString(50);
                                    messageClientService.sendMessageToAll(word,userId);
                                    break;
                                case "3":
                                    System.out.print("请输入想聊天的用户:");
                                    String sendTo = com.test.qqclient.utils.Utility.readString(50);
                                    System.out.print("请输入想说的话:");
                                    String msg = com.test.qqclient.utils.Utility.readString(50);
                                    messageClientService.sendMessageToOne(msg,userId,sendTo);
                                    break;
                                case "4":
                                    System.out.print("要发给谁:");
                                    String getter = Utility.readString(50);
                                    System.out.print("源文件");
                                    String src = Utility.readString(50);
                                    System.out.print("目标");
                                    String dest = Utility.readString(50);
                                    fileClientService.sendFileToOne(src,dest,userId,getter);
                                    break;
                                case "9":
                                    userClientService.logout();
                                    loop = false;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    else {
                        System.out.println("登录失败");
                    }
                    break;
                case "9":
                    System.out.println("退出");
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
