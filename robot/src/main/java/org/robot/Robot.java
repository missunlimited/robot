package org.robot;

import java.util.*;

/**
 * ロボットのプロフィールを宣言するクラス
 */
public class Robot {
    private String name;
    private ArrayList<Robot> friendLists = new ArrayList<>();

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Robot> getFriendLists() {
        return friendLists;
    }

    public void setFriendLists(ArrayList<Robot> friendLists) {
        this.friendLists = friendLists;
    }

    /**
     * 友達を追加する関数
     * @param robot 追加したいロボット
     */
    public void addFriend(Robot robot) {
        // 自分自身と友達になる可能性を防ぐ処理
        if (this == robot) {
            return;
        }
        // 自分の友達の中に既に友達として存在しないことを確認する処理
        if (this.getFriendLists().contains(robot) == false) {
            this.getFriendLists().add(robot);
        }
    }

    /**
     * 任意のロボットの友達個体数をカウントする関数
     * @return 友達の個体数
     */
    public int numberOfFriends() {
        if (friendLists.size() == 0) {
            return 0;
        } else {
            return friendLists.size();
        }
    }

    /**
     * 共通の友達を配列に格納する関数
     * @return 共通の友達を格納したリスト
     */
    public Set<Robot> getCommonFriend() {
        Set<Robot> commonFriend = new HashSet<>();
        for (Robot friend : this.friendLists) {
            for (Robot friendsFriend : friend.getFriendLists())
                // 共通の友達をリストに格納（自分自身を含む）
                commonFriend.add(friendsFriend);
        }
        // 自分自身を削除する処理
        commonFriend.remove(this);
        return commonFriend;
    }

    /**
     * 共通の友達を確認する関数
     * @param targetRobot 友達の友達までの範囲にいるかを確認したいロボット
     * @return 友達の友達にいる or いない
     */
    public boolean checkCommonFriend(Robot targetRobot) {
        if (getCommonFriend().contains(targetRobot)) {
            return true;
        } else {
            return false;
        }
    }
}
