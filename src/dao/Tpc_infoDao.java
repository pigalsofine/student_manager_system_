package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Sc_Course;
import entity.Student_basic_info;
import entity.Tpc_info;
import util.DBHelper;

public class Tpc_infoDao {
	public ArrayList<Tpc_info> getTpc_infos(String sno,int grade){
		return null;
		/*Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Tpc_info> tpc_info_list = new ArrayList<Tpc_info>();
		Tpc_info tpc_info = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SNO_Award_Search ? ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());
			stmt.setInt(2, String.valueOf(grade).toUpperCase());
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
		return sc_Course_list;*/
	}
	//�������-�༶�Ų�ѯ�ɼ�
	public ArrayList<Tpc_info> getTpc_score_with_clsno(String clsno){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Tpc_info> tpc_info_list = new ArrayList<Tpc_info>();
		Tpc_info tpc_info = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec CN_GRADE_Search  ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, clsno.toUpperCase());
			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				tpc_info = new Tpc_info(); 
				tpc_info.setCname(rs.getString("cname"));
				tpc_info.setGrade(rs.getInt("grade"));
				tpc_info.setSno(rs.getString("sno"));
				tpc_info.setCno(rs.getString("cno"));
				tpc_info.setScore(rs.getInt("score"));
				tpc_info.setCcredit(rs.getDouble("CCREDIT"));
				tpc_info_list.add(tpc_info);
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
		return tpc_info_list;
	}
	//�������-רҵ���꼶 ��ѯ��ѧ�ƻ�
	public ArrayList<Tpc_info> getCoure(String SN,String grade ){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Tpc_info> tpc_info_list = new ArrayList<Tpc_info>();
		Tpc_info tpc_info = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SNO_Plan_Search  ?,?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, SN.toUpperCase());
			stmt.setString(2, grade.toUpperCase());
			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {

				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				tpc_info = new Tpc_info(); 
				tpc_info.setSpecialtyNo(rs.getString("specialtyNo"));
				tpc_info.setGrade(rs.getInt("grade"));
				tpc_info.setCno(rs.getString("cno"));
				tpc_info.setCname(rs.getString("cname"));
				tpc_info.setCcredit(rs.getDouble("CCREDIT"));
				tpc_info_list.add(tpc_info);
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
		return tpc_info_list;
	}
	//�������-רҵ�š��꼶 ��ѯ�ɼ�
	public ArrayList<Tpc_info> getTpc_score_with_SpNO_and_Ga(String spno,String ga){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Tpc_info> tpc_info_list = new ArrayList<Tpc_info>();
		Tpc_info tpc_info = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SpeNO_GRADE_Search  ? ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, spno.toUpperCase());
			stmt.setString(2, ga.toUpperCase());
			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				tpc_info = new Tpc_info(); 
				tpc_info.setGrade(rs.getInt("grade"));
				tpc_info.setSno(rs.getString("sno"));
				tpc_info.setCno(rs.getString("cno"));
				tpc_info.setScore(rs.getInt("score"));
				tpc_info.setCcredit(rs.getDouble("CCREDIT"));
				tpc_info_list.add(tpc_info);
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
		return tpc_info_list;
	}
	//�������-ѧ�š��γ̺š��³ɼ� �޸ĳɼ�
	public boolean change_score(String sno,String cno,int newG){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Tpc_info> tpc_info_list = new ArrayList<Tpc_info>();
		Tpc_info tpc_info = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec  SNO_GRADE_Update  ?, ?, ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());
			stmt.setString(2, cno.toUpperCase());
			stmt.setInt(3, newG);
			//rsΪ���ؽ��
			stmt.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			return false;
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
		return true;
	}
	
	public static void main(String[] args) {
		try {
			Tpc_infoDao tpc_infoDao = new Tpc_infoDao();
			tpc_infoDao.change_score("S120001 ", "c001", 50);
			System.out.println("ok");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
