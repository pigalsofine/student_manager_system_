package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Class_;
import entity.Student;
import util.DBHelper;

public class ClassDao {
	//�������-�༶�Ų鿴�༶��Ϣ��
	public ArrayList<Class_> getClass_accoding_clsno(String clsno) {
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Class_> class_list = new ArrayList<Class_>();
		Class_ class_ = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec ClassNO_Class_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, clsno.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				class_ = new Class_();
				class_.setClsno(rs.getString("clsno"));
				class_.setClsname(rs.getString("clsname"));
				class_.setGrade(rs.getInt("grade"));
				class_.setTotal_class_num(rs.getInt("scount"));
				class_.setSpecialtyName(rs.getString("faculty"));
				class_.setDirector(rs.getString("director"));
				class_list.add(class_);
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
		return class_list;
	}
	//�������-רҵ���Ʋ鿴�༶��Ϣ
	public ArrayList<Class_> getClass_accoding_clsName(String clsname) {
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Class_> class_list = new ArrayList<Class_>();
		Class_ class_ = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SName_Class_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, clsname.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				class_ = new Class_();
				class_.setClsno(rs.getString("clsno"));
				class_.setClsname(rs.getString("clsname"));
				class_.setGrade(rs.getInt("grade"));
				class_.setTotal_class_num(rs.getInt("scount"));
				class_.setSpecialtyName(rs.getString("specialtyName"));
				class_.setFaculty(rs.getString("faculty"));
				class_.setDirector(rs.getString("director"));
				class_list.add(class_);
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
		return class_list;
	}
	//�������-Ժϵ�鿴�༶��Ϣ
	public ArrayList<Class_> getClass_accoding_fa(String fa) {
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Class_> class_list = new ArrayList<Class_>();
		Class_ class_ = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec FA_Class_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, fa.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				class_ = new Class_();
				class_.setClsno(rs.getString("clsno"));
				class_.setClsname(rs.getString("clsname"));
				class_.setGrade(rs.getInt("grade"));
				class_.setTotal_class_num(rs.getInt("scount"));
				class_.setSpecialtyName(rs.getString("faculty"));
				class_.setDirector(rs.getString("director"));
				class_list.add(class_);
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
		return class_list;
	}
}
