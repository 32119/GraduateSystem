USE [coursedesign]
GO
/****** Object:  Table [dbo].[baogao]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[baogao](
	[student_id] [nchar](9) NOT NULL,
	[baogaomingcheng] [varchar](255) NULL,
	[baogaoleixing] [varchar](50) NULL,
	[baogaoshijian] [varchar](50) NULL,
	[baogaodanwei] [varchar](255) NULL,
	[gongxiandupaiming] [int] NULL,
	[zuozhengcailiao] [varchar](255) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[biaozhun]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[biaozhun](
	[student_id] [nchar](9) NOT NULL,
	[biaozhunmingcheng] [varchar](255) NULL,
	[biaozhunjibie] [varchar](50) NULL,
	[fabushijian] [varchar](50) NULL,
	[zuozhengcailiao] [varchar](255) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[course]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[course](
	[course_id] [nchar](4) NOT NULL,
	[course_name] [varchar](50) NULL,
	[course_renshu] [int] NULL,
	[course_duixiang] [varchar](50) NULL,
	[course_xingzhi] [varchar](50) NULL,
	[course_time] [varchar](50) NULL,
	[student_id] [nchar](9) NULL,
	[teacher_id] [nchar](4) NULL,
 CONSTRAINT [PK_course] PRIMARY KEY CLUSTERED 
(
	[course_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[jiangli]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[jiangli](
	[student_id] [nchar](9) NOT NULL,
	[jianglimingcheng] [varchar](255) NULL,
	[jianglidengji] [varchar](50) NULL,
	[huojiangdengji] [varchar](50) NULL,
	[paiming] [int] NULL,
	[huojiangshijian] [varchar](50) NULL,
	[zuozhengcailiao] [varchar](255) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[jiaocai]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[jiaocai](
	[student_id] [nchar](9) NOT NULL,
	[jiaocaimingcheng] [varchar](255) NULL,
	[chubanshe] [varchar](255) NULL,
	[chubanshijian] [varchar](255) NULL,
	[gongxiandupaiming] [int] NULL,
	[zuozhengcailiao] [varchar](255) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[lunwen]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[lunwen](
	[student_id] [nchar](9) NOT NULL,
	[lunwenmingcheng] [varchar](255) NULL,
	[kanwumingcheng] [varchar](255) NULL,
	[lunwenzhuangtai] [varchar](255) NULL,
	[fabiaoshijian] [varchar](50) NULL,
	[suoyinleixing] [varchar](255) NULL,
	[guishukuqingkuang] [varchar](255) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pingding]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pingding](
	[pingding_id] [int] NOT NULL,
	[course_id] [nchar](4) NOT NULL,
	[student_id] [nchar](9) NOT NULL,
	[zishu] [varchar](255) NULL,
	[laoshipingjia] [varchar](255) NULL,
	[pingjiajieguo] [varchar](50) NULL,
 CONSTRAINT [PK_pingding] PRIMARY KEY CLUSTERED 
(
	[pingding_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pingtai]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pingtai](
	[student_id] [nchar](9) NOT NULL,
	[pingtaimingcheng] [varchar](255) NULL,
	[fuwudanwei] [varchar](255) NULL,
	[shangxianshijian] [varchar](50) NULL,
	[gongxiandupaiming] [int] NULL,
	[zuozhengcailiao] [varchar](255) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[project]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[project](
	[project_id] [nchar](4) NOT NULL,
	[project_name] [varbinary](255) NULL,
	[project_type] [varchar](255) NULL,
	[student_id] [nchar](9) NULL,
	[teacher_id] [nchar](4) NULL,
	[canyushijian] [varchar](50) NULL,
	[chengdangongzuo] [varchar](255) NULL,
	[zhehejingfei] [float] NULL,
 CONSTRAINT [PK_project] PRIMARY KEY CLUSTERED 
(
	[project_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[qitachengguo]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[qitachengguo](
	[student_id] [nchar](9) NOT NULL,
	[qitachengguo] [varchar](255) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[shenbao]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shenbao](
	[shenbao_id] [int] NOT NULL,
	[student_id] [nchar](9) NULL,
	[zhiyuan1_id] [nchar](4) NULL,
	[zhiyuan2_id] [nchar](4) NULL,
	[zhiyuan1_jieguo] [varchar](50) NULL,
	[zhiyuan2_jieguo] [varchar](50) NULL,
 CONSTRAINT [PK_shenbao] PRIMARY KEY CLUSTERED 
(
	[shenbao_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[student]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student](
	[student_id] [nchar](9) NOT NULL,
	[student_name] [varchar](50) NULL,
	[student_type] [varchar](50) NULL,
	[student_faculty] [varchar](50) NULL,
	[student_subject] [nchar](4) NULL,
	[student_tutor] [nchar](4) NULL,
 CONSTRAINT [PK_student] PRIMARY KEY CLUSTERED 
(
	[student_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[subject]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[subject](
	[subject_id] [nchar](4) NOT NULL,
	[subject_name] [varchar](50) NULL,
 CONSTRAINT [PK_subject] PRIMARY KEY CLUSTERED 
(
	[subject_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[teacher]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[teacher](
	[teacher_id] [nchar](4) NOT NULL,
	[teacher_name] [varchar](50) NULL,
	[whether] [varchar](3) NULL,
	[teacher_subject] [nchar](4) NULL,
 CONSTRAINT [PK_teacher] PRIMARY KEY CLUSTERED 
(
	[teacher_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[xueshu]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[xueshu](
	[xueshu_id] [nchar](4) NOT NULL,
	[xueshu_name] [varchar](100) NULL,
	[xueshu_didian] [varchar](255) NULL,
	[xueshu_shijian] [varchar](50) NULL,
	[baogaomingcheng] [varchar](255) NULL,
	[student_id] [nchar](9) NULL,
 CONSTRAINT [PK_xueshu] PRIMARY KEY CLUSTERED 
(
	[xueshu_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[zhuanli]    Script Date: 2022/12/26 14:24:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[zhuanli](
	[zhuanli_id] [nchar](4) NOT NULL,
	[student_id] [nchar](9) NOT NULL,
	[zhuanlimingcheng] [varchar](255) NULL,
	[zhuanlileixing] [varchar](50) NULL,
	[fabushijian] [varchar](50) NULL,
	[zhuanlizhuangtai] [varchar](50) NULL,
	[gongxiandupaiming] [int] NULL,
	[zuozhengcailiao] [varchar](255) NULL,
 CONSTRAINT [PK_zhuanli] PRIMARY KEY CLUSTERED 
(
	[zhuanli_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
