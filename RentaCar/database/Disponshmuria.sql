USE [RentaCar]
GO

/****** Object:  Table [dbo].[Disponshmuria]    Script Date: 6/1/2018 11:48:50 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Disponshmuria](
	[DisponshmuriaID] [int] IDENTITY(1,1) NOT NULL,
	[Disponshmuria] [varchar](50) NOT NULL,
 CONSTRAINT [PK_DisponshmuriaID_1] PRIMARY KEY CLUSTERED 
(
	[DisponshmuriaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


