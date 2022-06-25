package org.robot;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ・ロボットが任意の数存在します（3体以上で自由に決めて良い）。
 * ・ロボットは、任意のロボットと友達になることができます（何体友達になっても構いません）。
 * ・任意のロボットは、友達になったロボット数を計算でき、教えてくれます。
 * ・任意のロボットは、友達になったロボット一覧を把握しています。
 * ・任意のロボットは、特定のロボットが友達の友達までの範囲内に存在するかを確認することができます。
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("=====ロボットの個体数を入力してください=====");
        Scanner scanner = new Scanner(System.in);
        int numberOfRobotIndividual = scanner.nextInt();
        if (numberOfRobotIndividual < 3) {
            throw new InputMismatchException("3以上を入力してください。");
        }

        MakeRobot makeRobot = new MakeRobot();
        ArrayList<Robot> allRobot;
        allRobot = makeRobot.makeRobot(numberOfRobotIndividual);
        makeRobot.addFriendRobot(100, allRobot);

        for (int i = 0; i < allRobot.size(); i++) {
            System.out.print("======================================\n");
            System.out.println(allRobot.get(i).getName());

            System.out.print("友達一覧 : ");
            for (Robot friend : allRobot.get(i).getFriendLists()) {
                System.out.print(friend.getName() + " ");
            }
            System.out.print("\n");
            System.out.println("友達の個体数 : " + allRobot.get(i).numberOfFriends());
        }
        System.out.println("======================================");

        System.out.println("友達の友達を確認したいロボットナンバーを入力してください。 例)ロボット1 ▷ 1");
        int checkRobotNum = scanner.nextInt();
        if (0 > checkRobotNum || checkRobotNum > numberOfRobotIndividual - 1) {
            throw new InputMismatchException("入力された値が不正です。");
        }
        System.out.println("友達の友達までの範囲にいるか確認したいロボットナンバーを入力してください。 例)ロボット1 ▷ 1");
        int checkTargetRobotNum = scanner.nextInt();
        if (0 > checkTargetRobotNum || checkTargetRobotNum > numberOfRobotIndividual - 1) {
            throw new InputMismatchException("入力された値が不正です。");
        }
        if (allRobot.get(checkRobotNum).checkCommonFriend(allRobot.get(checkTargetRobotNum))) {
            System.out.println("ロボット" + checkTargetRobotNum + "はロボット" + checkRobotNum + "の友達の友達までの範囲にいます。");
        } else {
            System.out.println("ロボット" + checkTargetRobotNum + "はロボット" + checkRobotNum + "の友達の友達までの範囲にいません。");
        }
    }
}
