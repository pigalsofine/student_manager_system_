package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Class_;
import entity.Specialty;
import entity.Student_basic_info;
import util.DBHelper;

public class SpecialtyDao {
	
	public ArrayList<Specialty> getAllFA() {
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Specialty> specialty_list = new ArrayList<Specialty>();
		Specialty specialty = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec Faculty_Search";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			
			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				specialty = new Specialty();
				specialty.setFaculty(rs.getString("faculty"));
				specialty_list.add(specialty);
				System.out.println(rs.getString("faculty"));
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
		return specialty_list;
	}
	
	public ArrayList<Specialty> getSpe_accoding_fa(String fa) {
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Specialty> specialty_list = new ArrayList<Specialty>();
		Specialty specialty = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec FA_Spe_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, fa.toUpperCase());
			
			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				specialty = new Specialty();
				specialty.setSpecialtyName(rs.getString("specialtyName"));
				specialty.setSpecialtyNo(rs.getString("specialtyNo"));
				specialty_list.add(specialty);
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
		return specialty_list;
	}
	
	public static void main(String[] args) {
		try {
			SpecialtyDao specialtyDao = new SpecialtyDao();
			ArrayList<Specialty> specialty_list = specialtyDao.getSpe_accoding_fa("��Ϣ����ϵ");
			for (int i = 0; i < specialty_list.size(); i++) {
				System.out.println(specialty_list.get(i).getSpecialtyName());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
}
