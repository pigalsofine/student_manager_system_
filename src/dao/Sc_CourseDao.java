package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Punishment;
import entity.Sc_Course;
import util.DBHelper;

public class Sc_CourseDao {
	public ArrayList<Sc_Course> getSc_Course_infos(String sno){
		Connection conn = null;
		PreparedStatement stmt = null;//语句对象
		ResultSet rs = null;//数据集
		ArrayList<Sc_Course> sc_Course_list = new ArrayList<Sc_Course>();
		Sc_Course sc_Course = null;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "exec SNO_Grade_Search ?";//sql语句
			stmt = conn.prepareStatement(sql);
			//将传进来的参数替代问号处
			stmt.setString(1, sno.toUpperCase());

			//rs为返回结果
			rs = stmt.executeQuery();
			//遍历返回的结果
			while (rs.next()) {
				//将获取到的用户信息给User，作为函数返回值
				sc_Course = new Sc_Course();
				sc_Course.setCno(rs.getString("cno"));
				sc_Course.setCname(rs.getString("cname"));
				sc_Course.setGrade(rs.getInt("grade"));
				sc_Course.setCcredit(rs.getDouble("ccredit"));
				sc_Course_list.add(sc_Course);
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
		return sc_Course_list;
	}
	
	//总学分
	public int getTotal_credits(String sno) {
		Connection conn = null;
		CallableStatement  stmt = null;//语句对象
		ResultSet rs = null;//查询返回的结果
		int returnInt = 0;
		try {
			//连接数据库
			conn = DBHelper.getConnection();
			//数据库执行语句,其中?为传进来的参数要替代的位置
			String sql = "{? = call SNO_SUM_Search (?)}";//sql语句
			
			stmt = conn.prepareCall(sql);
			stmt.setString(2, sno);
			stmt.registerOutParameter(1, java.sql.Types.INTEGER);  
			//rs为返回结果
			stmt.execute();
			System.out.println(stmt.getInt(1));
			//遍历返回的结果
			returnInt =  stmt.getInt(1);
			
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
		return returnInt;
	}
	
	//总学分
		public int getAvg_Search(String sno) {
			Connection conn = null;
			CallableStatement  stmt = null;//语句对象
			ResultSet rs = null;//查询返回的结果
			int returnInt = 0;
			try {
				//连接数据库
				conn = DBHelper.getConnection();
				//数据库执行语句,其中?为传进来的参数要替代的位置
				String sql = "{? = call SNO_AVG_Search (?)}";//sql语句
				
				stmt = conn.prepareCall(sql);
				stmt.setString(2, sno);
				stmt.registerOutParameter(1, java.sql.Types.INTEGER);  
				//rs为返回结果
				stmt.execute();
				System.out.println(stmt.getInt(1));
				//遍历返回的结果
				returnInt =  stmt.getInt(1);
				
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
			return returnInt;
		}


	
	public static void main(String[] args) {
		try {
			Sc_CourseDao sc_CourseDao = new Sc_CourseDao();
			int total_credits  = sc_CourseDao.getAvg_Search("S140072");
			System.out.println(total_credits);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
