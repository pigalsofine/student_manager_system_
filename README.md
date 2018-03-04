# student_manager_system
#这是基于jsp/servlet 写的学生学籍管理系统
基本功能
用户为学生
个人信息：
	修改密码
	个人信息（学号，姓名，性别，学院，专业 ，班级，入学年份，注册情况等）
	体检信息
	奖惩情况
成绩相关
	成绩查询（学年，课程号，课程名称，成绩，学分，最后加一个平均成绩和总学分）
课程信息
	计划查询（学年）
	个人课表*

用户为管理员
	学生学籍管理
		学籍注册
			注册信息查询（查询的是某个年级某个院系的某个专业）
			注册信息修改（录入注册信息）
		异动处理
选择异动学生班级（查询的是某个年级某个院系的某个专业的某个班级的全部学生）
点击异动按钮（自动显示原年级-原院系-原专业-原班级），选择异动去向（选择新年级-新院系-新专业-新班级，选择异动原因：转专业/编下）
	基础数据（完成查询功能）
		学生信息
学生个人信息（查询信息 - 学号，姓名，性别，学院，专业 ，班级，入学年份）
		班级信息
			班级号，班级名称，年级，班级人数，所属专业，所属院系，辅导员
		院系信息
			院系-院系介绍xxxxxxxx-包含专业
		课程信息（计划查询-学年）
	成绩管理
		成绩查询
			（针对班级和专业）
		成绩修改
（针对单个学生，输入学号，--学年，课程号，课程名称，成绩，学分，后面加一个修改的选项
	其他
		获奖情况
			查询获奖信息（按专业显示）；
			插入获奖信息（可批量插入数据）。
		惩罚情况
			查询惩罚信息（按专业显示）；
			插入惩罚信息（可批量插入数据）。
		体检情况
			查询体检信息（按专业显示，已体检人数，未体检人数-可查询都有谁）；
			插入体检信息（可批量插入数据）。
![Alt text](https://github.com/chenyufeng1991/NewsClient/raw/master/Screenshots/2.png)
