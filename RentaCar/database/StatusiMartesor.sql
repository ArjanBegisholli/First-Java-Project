USE [RentaCar]
GO

/****** Object:  Table [dbo].[StatusiMartesor]    Script Date: 6/1/2018 11:51:55 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[StatusiMartesor](
	[StatusiMartesorID] [int] IDENTITY(1,1) NOT NULL,
	[StatusiMartesor] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[StatusiMartesorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


