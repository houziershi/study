<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!-- xsl:apply-templates only effects
		 on the element match the xpath express -->
	<xsl:template match="/">
		<html>
			<head>
				<script type="text/javascript" src="cdcatalog.js"></script>
			</head>
			<body>
				<h2>My CD Collection</h2> 
				<xsl:apply-templates/>             <!-- apply root -->
			</body>
		</html>
	</xsl:template>

	<xsl:template match="cd">
		<p>
			<xsl:apply-templates select="title"/>  <!-- apply the title -->
			<xsl:apply-templates select="artist"/> <!-- apply the title -->
		</p>
	</xsl:template>

	<xsl:template match="title">
		Title: 
		<span style="color:#ff0000">
			<xsl:value-of select="."/></span>
		<br />
	</xsl:template>

	<xsl:template match="artist">
		Artist: 
		<span style="color:#00ff00">
			<xsl:value-of select="."/></span>
		<br />
	</xsl:template>

</xsl:stylesheet>
