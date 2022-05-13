package homework;

public class Work01 {
    public static void main(String[] args) {
        System.out.println("====work01=======");
        A01 a01 = new A01();
        double[] arr = {900.1, 341.4, 9032.45, 123};
        System.out.println("Max is " + a01.max(arr));

        System.out.println("=====work02========");
        A02 a02 = new A02();
        String[] strArr = {"Hello", "world", "java", "javascript", "python", "PHP"};
        String str = "javascript";
        System.out.println("查找" + str + "在索引" + a02.find(str, strArr));

        System.out.println("=====work03========");
        Book book = new Book(10);
        book.updatePrice(800);
        book.showPrice();
        book.updatePrice(120);
        book.showPrice();

        System.out.println("====work04====");
        A03 a03 = new A03();
        int[] intArr = {1, 2, 3, 4, 3, 1, 2, 0};
        int[] newArr = a03.copyArr(intArr);
        System.out.print("新的数组:  ");
        a03.showArr(newArr);

        System.out.println("====work05====");
        Circle circle = new Circle();
        circle.getPerimeter(4);
        circle.getArea(4);

        System.out.println("=====work06====");
        Cale c1 = new Cale(10, 2);
        c1.add();
        Cale c2 = new Cale(9, 0);
        c2.div();
    }
}

class A01 {
    public double max(double... numbs) {
        double big = numbs[0];
        for (int i = 1; i < numbs.length; i++) {
            if (numbs[i] > big) {
                big = numbs[i];
            }
        }
        return big;
    }
}

class A02 {
    public int find(String str, String[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (str.equals(arr[i])) {
                index = i;
            }
        }
        return index;
    }
}

class Book {
    double price;

    public Book() {
    }

    public Book(double price) {
        this.price = price;
    }

    public void updatePrice(double newPrice) {
        if (newPrice > 150) {
            this.price = 150;
        } else if (newPrice > 100) {
            this.price = 100;
        } else {
            System.out.println("没有变化");
        }
    }

    public void showPrice() {
        System.out.println("book's price is " + this.price);
    }
}

class A03 {
    public int[] copyArr(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public void showArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class Circle {
    public void getPerimeter(double r) {
        System.out.println("圆的周长是:" + (2 * Math.PI * r));
    }

    public void getArea(double r) {
        System.out.println("圆的面积是:" + (Math.PI * r * r));
    }
}

class Cale {
    double n1;
    double n2;

    public Cale() {
    }

    public Cale(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public void add() {
        double result = n1 + n2;
        System.out.println(this.n1 + "+" + this.n2 + "=" + result);
    }

    public void div() {
        if (this.n2 == 0) {
            System.out.println("除数不为0");
        } else {
            double result = this.n1 / this.n2;
            System.out.println(this.n1 + "/" + this.n2 + "=" + result);
        }
    }


}