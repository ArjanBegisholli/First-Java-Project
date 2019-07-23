USE [RentaCar]
GO

/****** Object:  Table [dbo].[Llojivetures]    Script Date: 6/1/2018 11:50:12 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Llojivetures](
	[LlojiveturesID] [int] IDENTITY(1,1) NOT NULL,
	[Llojivetures] [varchar](50) NOT NULL,
 CONSTRAINT [PK_LlojiveturesID_1] PRIMARY KEY CLUSTERED 
(
	[LlojiveturesID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


