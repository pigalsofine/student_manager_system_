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
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Sc_Course> sc_Course_list = new ArrayList<Sc_Course>();
		Sc_Course sc_Course = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SNO_Grade_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
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
			//�ͷ����ݼ�����
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
			//�ͷ�������
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
	
	//��ѧ��
	public int getTotal_credits(String sno) {
		Connection conn = null;
		CallableStatement  stmt = null;//������
		ResultSet rs = null;//��ѯ���صĽ��
		int returnInt = 0;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "{? = call SNO_SUM_Search (?)}";//sql���
			
			stmt = conn.prepareCall(sql);
			stmt.setString(2, sno);
			stmt.registerOutParameter(1, java.sql.Types.INTEGER);  
			//rsΪ���ؽ��
			stmt.execute();
			System.out.println(stmt.getInt(1));
			//�������صĽ��
			returnInt =  stmt.getInt(1);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			//�ͷ����ݼ�����
			if (rs!=null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}				
			}
			//�ͷ�������
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
	
	//��ѧ��
		public int getAvg_Search(String sno) {
			Connection conn = null;
			CallableStatement  stmt = null;//������
			ResultSet rs = null;//��ѯ���صĽ��
			int returnInt = 0;
			try {
				//�������ݿ�
				conn = DBHelper.getConnection();
				//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
				String sql = "{? = call SNO_AVG_Search (?)}";//sql���
				
				stmt = conn.prepareCall(sql);
				stmt.setString(2, sno);
				stmt.registerOutParameter(1, java.sql.Types.INTEGER);  
				//rsΪ���ؽ��
				stmt.execute();
				System.out.println(stmt.getInt(1));
				//�������صĽ��
				returnInt =  stmt.getInt(1);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally{
				//�ͷ����ݼ�����
				if (rs!=null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}				
				}
				//�ͷ�������
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
