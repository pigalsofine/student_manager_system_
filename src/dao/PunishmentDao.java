package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Awarding;
import entity.Punishment;
import util.DBHelper;

public class PunishmentDao {
	public ArrayList<Punishment> getPunishment_infos_with_sno(String sno){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Punishment> punishment_list = new ArrayList<Punishment>();
		Punishment punishment = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SNO_Punish_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				punishment = new Punishment();
				punishment.setSno(rs.getString("sno"));
				punishment.setPunish(rs.getString("punish"));
				punishment.setPdate(rs.getString("pdate"));
				punishment_list.add(punishment);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			//释放数据集对象
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
			//释放语句对象
			if (stmt!=null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
		}
		return punishment_list;
	}
	//传入参数-专业号查询惩罚情况
	public ArrayList<Punishment> getPunishment_infos_with_SpNo(String spno){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Punishment> punishment_list = new ArrayList<Punishment>();
		Punishment punishment = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SpeNO_PUN_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, spno.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				punishment = new Punishment();
				punishment.setSno(rs.getString("sno"));
				punishment.setPunish(rs.getString("punish"));
				punishment.setPdate(rs.getString("pdate"));
				punishment_list.add(punishment);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			//释放数据集对象
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
			//释放语句对象
			if (stmt!=null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
		}
		return punishment_list;
	}

	
	public static void main(String[] args) {
		try {
			PunishmentDao punishmentDao = new PunishmentDao();
			ArrayList<Punishment> punishment_list = punishmentDao.getPunishment_infos_with_sno("S140072");
			for (int i = 0; i < punishment_list.size(); i++) {
				System.out.println(punishment_list.get(i).print());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//传入参数-学号、惩罚、时间 添加惩罚信息
	public boolean add_punishment_info(String sno,String pu,String pd){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SNO_PUN_Insert ? ,?, ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());
			stmt.setString(2, pu.toUpperCase());
			stmt.setString(3, pd.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally{
			//释放数据集对象
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
			//释放语句对象
			if (stmt!=null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
		}
		return true;
	}
}
