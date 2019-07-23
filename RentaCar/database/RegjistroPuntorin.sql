USE [RentaCar]
GO

/****** Object:  Table [dbo].[RegjistroPuntorin]    Script Date: 6/1/2018 11:51:18 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[RegjistroPuntorin](
	[PuntoriID] [int] IDENTITY(1,1) NOT NULL,
	[Emri] [varchar](50) NOT NULL,
	[Mbiemri] [varchar](50) NOT NULL,
	[Ditelindja] [date] NOT NULL,
	[UserName] [varchar](50) NOT NULL,
	[Password] [varchar](100) NOT NULL,
	[GjiniaID] [int] NOT NULL,
	[StatusiMartesorID] [int] NOT NULL,
	[Adresa] [varchar](100) NOT NULL,
	[NrLeternjoftimit] [varchar](50) NOT NULL,
	[Kontakti] [varchar](50) NOT NULL,
	[Rroga] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PuntoriID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


