package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Student;
import entity.Student_basic_info;
import entity.User;
import util.DBHelper;

public class Student_basic_infoDao {
	
	public boolean is_student(String sno) {
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		int flag = 0;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "select * from student where sno=?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			if (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				flag = 1;
				System.out.println("is the student");
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
		if(1==flag){
			return true;
		}else {
			return false;
		}
		
	}
	
	//�������-ѧ�Ų�ѯ������Ϣ
	public Student_basic_info getBasic_info(String sno){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		Student_basic_info student_basic_info = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SNO_BaIn_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			if (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				student_basic_info = new Student_basic_info();
				student_basic_info.setSno(rs.getString("sno"));
				student_basic_info.setSname(rs.getString("sname"));
				student_basic_info.setSsex(rs.getString("ssex"));
				student_basic_info.setFaculty(rs.getString("faculty"));
				student_basic_info.setSpecialtyName(rs.getString("specialtyName"));
				student_basic_info.setClsname(rs.getString("clsname"));
				student_basic_info.setEnterYear(rs.getInt("enterYear"));
				student_basic_info.setRegister(rs.getInt("register"));
			}else {
				System.out.println("no");
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
		return student_basic_info;
	}
	
	//��ȡѧ��ע����Ϣ
	public ArrayList<Student> getRegister_info(String sno){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Student> student_list = new ArrayList<Student>();
		Student student = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SNO_BaIn_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				student = new Student();
				student.setRegister(rs.getInt("register"));
				student.setSname(rs.getString("sname"));
				student.setSno(rs.getString("sno"));
				student_list.add(student);
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
		return student_list;
	}
	
	//����ѧ��ע��
	public boolean setRegister_info(String sno){
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec SN_REG_Update ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());

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
	//�������-�༶�Ų�ѯĳ���༶��ȫ��ѧ���������춯�༶ѡ��
	public ArrayList<Student> getStudent_accoding_clsno(String clsno) {
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Student> student_list = new ArrayList<Student>();
		Student student = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec CLSNO_STU_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, clsno.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				student = new Student();
				student.setSname(rs.getString("sname"));
				student.setSno(rs.getString("sno"));
				student.setClsNO(rs.getString("clsno"));
				student.setSsex(rs.getString("ssex"));
				student_list.add(student);
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
		return student_list;
	}
	//�����춯��
	public boolean change_classNo(String sno,String newclsno) {
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec CLSNO_STU_Change ? , ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			System.out.println(sno+" "+newclsno);
			
			System.out.println("�춯");
			stmt.setString(1, sno.toUpperCase());
			stmt.setString(2, newclsno.toUpperCase());
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
	//�������-�༶�Ų�ѯĳ���༶��ȫ��ѧ���������춯�༶ѡ��
	public ArrayList<Student> getStudent_accoding_specialtyNo(String specialtyNo) {
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		ArrayList<Student> student_list = new ArrayList<Student>();
		Student student = null;
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec  SN_REG_Search ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, specialtyNo.toUpperCase());

			//rsΪ���ؽ��
			rs = stmt.executeQuery();
			//�������صĽ��
			while (rs.next()) {
				//����ȡ�����û���Ϣ��User����Ϊ��������ֵ
				student = new Student();
				student.setSname(rs.getString("sname"));
				student.setSno(rs.getString("sno"));
				student.setRegister(rs.getInt("register"));
				student_list.add(student);
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
		return student_list;
	}
	//ɾ��ѧ��
	public boolean delete_student(String sno) {
		Connection conn = null;
		PreparedStatement stmt = null;//������
		ResultSet rs = null;//���ݼ�
		try {
			//�������ݿ�
			conn = DBHelper.getConnection();
			//���ݿ�ִ�����,����?Ϊ�������Ĳ���Ҫ�����λ��
			String sql = "exec  SNO_Delete ?";//sql���
			stmt = conn.prepareStatement(sql);
			//���������Ĳ�������ʺŴ�
			stmt.setString(1, sno.toUpperCase());

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
			Student_basic_infoDao studentDaoBasic_infoDao = new Student_basic_infoDao();
			Student_basic_info student_basic_info = studentDaoBasic_infoDao.getBasic_info("s120001");
			System.out.println(student_basic_info.print());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}


