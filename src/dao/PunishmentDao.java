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
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Punishment> punishment_list = new ArrayList<Punishment>();
		Punishment punishment = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SNO_Punish_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
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
		return punishment_list;
	}
	//�������-רҵ�Ų�ѯ�ͷ����
	public ArrayList<Punishment> getPunishment_infos_with_SpNo(String spno){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Punishment> punishment_list = new ArrayList<Punishment>();
		Punishment punishment = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SpeNO_PUN_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, spno.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
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
	
	//�������-ѧ�š��ͷ���ʱ�� ��ӳͷ���Ϣ
	public boolean add_punishment_info(String sno,String pu,String pd){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SNO_PUN_Insert ? ,?, ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());
			stmt.setString(2, pu.toUpperCase());
			stmt.setString(3, pd.toUpperCase());

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
}
