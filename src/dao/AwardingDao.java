package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Awarding;
import entity.Check_up;
import util.DBHelper;

public class AwardingDao {
	public ArrayList<Awarding> getAwarding_infos_with_sno(String sno){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Awarding> awarding_list = new ArrayList<Awarding>();
		Awarding awarding = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SNO_Award_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				awarding = new Awarding();
				awarding.setSno(rs.getString("sno"));
				awarding.setPrize(rs.getString("prize"));
				awarding.setAdate(rs.getString("adate"));
				awarding_list.add(awarding);
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
		return awarding_list;
	}
	//�������-רҵ�Ų�ѯ�����
	public ArrayList<Awarding> getAwarding_infos_with_spno(String spno){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Awarding> awarding_list = new ArrayList<Awarding>();
		Awarding awarding = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SpeNO_AWA_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, spno.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				awarding = new Awarding();
				awarding.setSno(rs.getString("sno"));
				awarding.setPrize(rs.getString("prize"));
				awarding.setAdate(rs.getString("adate"));
				awarding_list.add(awarding);
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
		return awarding_list;
	}
	//�������-ѧ�š����ʱ�� ��ӻ���Ϣ
	public boolean add_awarding_info(String sno,String pr,String ad){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SNO_AWA_Insert ? ,?, ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());
			stmt.setString(2, pr.toUpperCase());
			stmt.setString(3, ad.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
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
			AwardingDao awardingDao = new AwardingDao();
			
			awardingDao.add_awarding_info("S120001 ", "12", "21");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
