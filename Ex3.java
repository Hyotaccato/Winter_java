//1111 이효은

package homework;

import java.text.DecimalFormat;
import java.util.Scanner;

abstract class Shape {
    abstract double getCircum();
    abstract String type();
}

class Cir extends Shape {
    private double rad;

    public Cir(double rad) {
        this.rad = rad;
    }

    @Override
    double getCircum() {
        return 2 * Math.PI * rad;
    }

    @Override
    String type() {
        return "원";
    }
}

class Rec extends Shape {
    private double width;
    private double height;

    public Rec(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double getCircum() {
        return 2 * (width + height);
    }

    @Override
    String type() {
        return "사각형";
    }
}

class Sector extends Shape {
    private double rad;

    public Sector(double rad) {
        this.rad = rad;
    }

    @Override
    double getCircum() {
        return 2 * rad + 2 * Math.PI * rad;
    }

    @Override
    String type() {
        return "부채꼴";
    }
}

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DecimalFormat cirFormat = new DecimalFormat("#.###############");
        DecimalFormat recFormat = new DecimalFormat("#.0");
        DecimalFormat secFormat = new DecimalFormat("#.###############");
        DecimalFormat intFormat = new DecimalFormat("#");
        //소수점 몇자리 까지 쓰는 용도

        Shape[] sha = new Shape[7];
        int circleC = 0, rectC = 0, sectorC = 0;

        for (int i = 0; i < 7; i++) {
            int Choice = 0;

            while (Choice < 1 || Choice > 3) {
                System.out.print("도형을 선택하세요 (1: 원, 2: 사각형, 3: 부채꼴): ");
                Choice = sc.nextInt();
            }

            switch (Choice) {
                case 1:
                    System.out.print("반지름 입력: ");
                    double rad = sc.nextDouble();
                    sha[i] = new Cir(rad);
                    circleC++;
                    System.out.printf("반지름 %s인 원의 둘레는 %s\n\n", intFormat.format(rad), cirFormat.format(sha[i].getCircum()));
                    break;

                case 2:
                    System.out.print("가로 입력: ");
                    double width = sc.nextDouble();
                    System.out.print("세로 입력: ");
                    double height = sc.nextDouble();
                    sha[i] = new Rec(width, height);
                    rectC++;
                    System.out.printf("가로 %s이고 세로 %s인 사각형의 둘레는 %s\n\n", intFormat.format(width), intFormat.format(height), recFormat.format(sha[i].getCircum()));
                    break;

                case 3:
                    System.out.print("반지름 입력: ");
                    double sectorRad = sc.nextDouble();
                    sha[i] = new Sector(sectorRad);
                    sectorC++;
                    System.out.printf("반지름 %.1f인 부채꼴의 둘레는 %s\n\n", sectorRad, secFormat.format(sha[i].getCircum()));
                    break;
            }
        }

        System.out.println("*************************************");
        System.out.printf("%d개의 원과 %d개의 사각형과 %d개의 부채꼴 생성\n", circleC, rectC, sectorC);

        for (int i = 0; i < sha.length; i++) {
            String circumference = "";

            switch (sha[i].type()) {
                case "사각형":
                    circumference = recFormat.format(sha[i].getCircum());
                    break;
                case "원":
                    circumference = cirFormat.format(sha[i].getCircum());
                    break;
                case "부채꼴":
                    circumference = secFormat.format(sha[i].getCircum());
                    break;
            }

            System.out.printf("%d번째 도형 : 둘레 %s인 %s\n", i + 1, circumference, sha[i].type());
        }

        double maxC = sha[0].getCircum();
        int maxI = 0;

        for (int i = 1; i < sha.length; i++) {
            if (sha[i].getCircum() > maxC) {
                maxC = sha[i].getCircum();
                maxI = i;
            }
        }

        String maxCir = "";
        switch (sha[maxI].type()) {
            case "사각형":
                maxCir = recFormat.format(maxC);
                break;
            case "원":
                maxCir = cirFormat.format(maxC);
                break;
            case "부채꼴":
                maxCir = secFormat.format(maxC);
                break;
        }

        System.out.printf("둘레의 길이가 가장 긴 도형 : 둘레 %s인 %d번째 도형으로 %s이다.\n", maxCir, maxI + 1, sha[maxI].type());

        sc.close();
    }
}
