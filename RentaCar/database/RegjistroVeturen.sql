USE [RentaCar]
GO

/****** Object:  Table [dbo].[RegjistroVeturen]    Script Date: 6/1/2018 11:51:33 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[RegjistroVeturen](
	[VeturaID] [int] IDENTITY(1,1) NOT NULL,
	[Modeli] [varchar](50) NOT NULL,
	[LlojiveturesID] [int] NULL,
	[Targat] [varchar](50) NOT NULL,
	[Ngjyra] [varchar](50) NOT NULL,
	[FurnizimiID] [int] NULL,
	[MarshiID] [int] NULL,
	[VitiProdhimit] [date] NOT NULL,
	[Kilometrazha] [float] NOT NULL,
	[CmimiVetures] [float] NOT NULL,
	[StockNumber] [int] NOT NULL,
	[VIN] [varchar](50) NOT NULL,
	[MaxWeight] [float] NOT NULL,
	[Pershkrimi] [varchar](100) NULL,
	[DisponshmuriaID] [int] NULL,
	[CmimiVeturespernjediteRent] [float] NOT NULL,
	[StatusiID] [int] NULL,
 CONSTRAINT [PK_VeturaID_1] PRIMARY KEY CLUSTERED 
(
	[VeturaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


