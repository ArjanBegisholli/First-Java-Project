USE [RentaCar]
GO

/****** Object:  Table [dbo].[RegjistroKlientin]    Script Date: 6/1/2018 11:51:04 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[RegjistroKlientin](
	[KlientiID] [int] IDENTITY(1,1) NOT NULL,
	[Emri] [varchar](50) NOT NULL,
	[Mbiemri] [varchar](50) NOT NULL,
	[Ditelindja] [date] NOT NULL,
	[Adresa] [varchar](50) NOT NULL,
	[Kontakti] [varchar](100) NOT NULL,
	[NrPersonal] [varchar](100) NOT NULL,
	[GjiniaID] [int] NOT NULL,
 CONSTRAINT [PK_RegjistroKlientin] PRIMARY KEY CLUSTERED 
(
	[KlientiID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


