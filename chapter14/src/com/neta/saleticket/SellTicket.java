package com.neta.saleticket;

public class SellTicket {
    public static void main(String[] args) {
        SellTicketThread sellTicketThread = new SellTicketThread();
        SellTicketThread sellTicketThread1 = new SellTicketThread();
        SellTicketThread sellTicketThread2 = new SellTicketThread();

        sellTicketThread.start();
        sellTicketThread1.start();
        sellTicketThread2.start();
    }
}


class SellTicketThread extends Thread{

    private static int ticketNum = 100;

    @Override
    public void run() {
        while(true){
            if(ticketNum <= 0){
                System.out.println("不卖了");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("卖出一张票，还剩"+ --ticketNum+"张，线程名"+Thread.currentThread().getName());

        }
    }
}
