package Utils;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import DAO.*;
import VO.Item;
import VO.Player;
import VO.Unit;

public class Utils {
	private static Scanner sc = new Scanner(System.in);
	private static final String CUR_PATH = System.getProperty("user.dir") + "//src//"
			+ Utils.class.getPackageName() + "//";

	public static int getInt(String msg, int start, int end) {
		System.out.println(msg);
		int sel = -1;
		try {
			sel = sc.nextInt();
			if (sel < start || sel > end) {
				System.out.println("선택 범위 오류");
				return -1;
			}
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요");
		}
		sc.nextLine();
		return sel;
	}

	public static void FileSave(GuildDAO gd, ShopDAO sd, InventoryDAO id, Player p) {
		String gameData = "";
		String fileName = "gameData.txt";
		ArrayList<Unit> temp = gd.getUnitList();

		try (FileWriter fw = new FileWriter(CUR_PATH+fileName)){
			gameData += p.getMoney();
			gameData += "\r\n";
			gameData += temp.size();
			gameData += "\r\n";
			for (int i = 0; i < temp.size(); i++) {
				gameData += temp.get(i).getName();
				gameData += "/";
				gameData += temp.get(i).getLevel();
				gameData += "/";
				gameData += temp.get(i).getMaxHp();
				gameData += "/";
				gameData += temp.get(i).getAtt();
				gameData += "/";
				gameData += temp.get(i).getDef();
				gameData += "/";
				gameData += temp.get(i).isParty();
				gameData += "\r\n";
				if (temp.get(i).getWeapon() == null) {
					gameData += temp.get(i).getWeapon();
				} else {
					Item item = temp.get(i).getWeapon();
					String weaponData = "";
					weaponData += item.getKind();
					weaponData += ",";
					weaponData += item.getName();
					weaponData += ",";
					weaponData += item.getPower();
					weaponData += ",";
					weaponData += item.getPrice();
					gameData += weaponData;

				}
				gameData += "/";
				if (temp.get(i).getArmor() == null) {
					gameData += temp.get(i).getArmor();
				} else {
					Item item = temp.get(i).getArmor();
					String weaponData = "";
					weaponData += item.getKind();
					weaponData += ",";
					weaponData += item.getName();
					weaponData += ",";
					weaponData += item.getPower();
					weaponData += ",";
					weaponData += item.getPrice();
					gameData += weaponData;

				}
				gameData += "/";
				if (temp.get(i).getRing() == null) {
					gameData += temp.get(i).getRing();
				} else {
					Item item = temp.get(i).getRing();
					String weaponData = "";
					weaponData += item.getKind();
					weaponData += ",";
					weaponData += item.getName();
					weaponData += ",";
					weaponData += item.getPower();
					weaponData += ",";
					weaponData += item.getPrice();
					gameData += weaponData;
				}
				gameData += "\r\n";
			}
			gameData += p.getPlayerItem().size();
			gameData += "\r\n";
			for (int i = 0; i < p.getPlayerItem().size(); i++) {
				Item item = p.getPlayerItem().get(i);

				gameData += item.getKind();
				gameData += ",";
				gameData += item.getName();
				gameData += ",";
				gameData += item.getPower();
				gameData += ",";
				gameData += item.getPrice();
				gameData += "\r\n";
			}
			fw.write(gameData);
			System.out.println(fileName + "저장 성공");
		} catch (Exception e) {
			System.out.println(fileName + "저장 실패");
		}
	}

	public static void FileLoad(GuildDAO gd, ShopDAO sd, InventoryDAO id, Player p) {

	}
}