USE [RentaCar]
GO

/****** Object:  Table [dbo].[RegjistroHuazimet]    Script Date: 6/1/2018 11:50:47 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[RegjistroHuazimet](
	[HuazimetID] [int] IDENTITY(1,1) NOT NULL,
	[EmriKlientit] [varchar](50) NULL,
	[MbiemriKlientit] [varchar](50) NULL,
	[NrPersonal] [varchar](50) NULL,
	[Llojivetures] [varchar](50) NULL,
	[Modeli] [varchar](50) NULL,
	[Ngjyra] [varchar](50) NULL,
	[RentnDit] [varchar](50) NULL,
	[DataKthimit] [date] NULL,
	[DataHuazimit] [date] NULL,
 CONSTRAINT [PK_HuazimetID_1] PRIMARY KEY CLUSTERED 
(
	[HuazimetID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


