USE [RentaCar]
GO

/****** Object:  Table [dbo].[Marshi]    Script Date: 6/1/2018 11:50:34 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Marshi](
	[MarshiID] [int] IDENTITY(1,1) NOT NULL,
	[Marshi] [varchar](50) NOT NULL,
 CONSTRAINT [PK_MarshiID_1] PRIMARY KEY CLUSTERED 
(
	[MarshiID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


