
-- =============================================
-- Author:		<Alberto Tejos>
-- Create date: <11-11-2014>
-- Description:	<SP_REPORTES_TICKETS>
-- =============================================
-- EXEC SP_REPORTES_TICKETS '01-01-1900', '01-11-2014', '045'
ALTER PROCEDURE [dbo].[SP_REPORTES_TICKETS]
@fecha_desde datetime = '01-10-2014',   
@fecha_hasta datetime = '01-11-2014',
@cod_linea_aerea char (3) = '045'
AS
BEGIN
	SET NOCOUNT ON;
	
	declare @iva_comision decimal(18, 2)

	IF(@cod_linea_aerea <> '')
	BEGIN 
	
		SELECT cod_linea_aerea, 
		CASE 
			WHEN (tipo = 'TKT') THEN 'TICKET' ELSE tipo 
		END as tipo,
		moneda, pnr, 
		ticket, 
		CONVERT(VARCHAR(30), fecha_emision, 105) AS fecha_emision,
		valor_neto,
		valor_tasas, valor_final, 
		comision, 
		CASE 
			WHEN(comision > 0) 
			THEN CONVERT(decimal(18,2),((valor_final/100)*1)) ELSE 0 
		END AS valor_comision, 

		CASE WHEN(comision > 0) THEN
		CONVERT(decimal(18,2),((valor_final/100)*1)*0.19) ELSE 0
		END
		AS iva_comision,
		
		CASE 
			WHEN (valor_neto > 0 AND comision > 0) 
			
			THEN CONVERT(decimal(18,2),((valor_final/100*1)+valor_final-CONVERT(decimal(18,2),((valor_final/100)*1)*0.19))) ELSE 0  
		END
		AS valor_a_pagar,

		CASE 
			WHEN (tipo = 'TKT' and moneda = 'CLP') 
			THEN (SELECT SUM(valor_neto) FROM ticket WHERE fecha_emision BETWEEN @fecha_desde AND @fecha_hasta
			AND cod_linea_aerea = @cod_linea_aerea AND tipo = 'TKT' and moneda = 'CLP')
			 
			WHEN (tipo = 'TKT' and moneda = 'USD') 
			THEN (SELECT CONVERT(FLOAT, ROUND(SUM(valor_neto), 2, 1)) FROM ticket WHERE fecha_emision BETWEEN @fecha_desde AND @fecha_hasta
			AND cod_linea_aerea = @cod_linea_aerea AND tipo = 'TKT' and moneda = 'USD')
			
			WHEN (tipo = 'EMD') 
			THEN (SELECT SUM(valor_final) FROM ticket WHERE fecha_emision BETWEEN @fecha_desde AND @fecha_hasta
			AND cod_linea_aerea = @cod_linea_aerea AND tipo = 'EMD')
		END AS valor_total
		



		FROM TICKET 
		WHERE fecha_emision BETWEEN @fecha_desde AND @fecha_hasta
		AND cod_linea_aerea = @cod_linea_aerea
		GROUP BY moneda, ticket, cod_linea_aerea, valor_tasas, valor_neto, valor_final, comision, tipo, pnr, fecha_anula,
		fecha_emision, fecha_remision
		ORDER BY moneda asc, cod_linea_aerea asc
	
	END ELSE BEGIN
	
		SELECT cod_linea_aerea, 
		CASE 
			WHEN (tipo = 'TKT') THEN 'TICKET' ELSE tipo 
		END as tipo,
		moneda, pnr, 
		ticket, convert(VARCHAR(30), fecha_emision, 105) as fecha_emision,
		valor_neto, valor_tasas, valor_final, 
		comision, 
		CASE 
			WHEN(comision > 0) THEN CONVERT(decimal(18,2),((valor_final/100)*1)) ELSE 0 
		END AS valor_comision, 
		CASE 
			WHEN (valor_neto > 0) THEN CONVERT(decimal(18,2),((valor_final/100*1)+valor_final)) ELSE 0 
		END	AS valor_a_pagar,
		CASE 
			WHEN (tipo = 'TKT') 
			THEN (SELECT SUM(valor_neto) FROM ticket WHERE fecha_emision BETWEEN @fecha_desde AND @fecha_hasta)
		END AS valor_total
		FROM TICKET 
		WHERE fecha_emision BETWEEN @fecha_desde AND @fecha_hasta
		GROUP BY moneda, ticket, cod_linea_aerea, valor_tasas, valor_neto, valor_final, comision, tipo, pnr, fecha_anula,
		fecha_emision, fecha_remision
		ORDER BY moneda asc, cod_linea_aerea asc
			
			
		
		END
	
END
