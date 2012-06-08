<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method='html' version='1.0' encoding='UTF-8' indent='yes'/>

<!-- xsl:template create an template
	 use date from the xpath "/" -->
<xsl:template match="/">
	<html>
		<body>
			<h2>My CD Collection</h2>
			<table border="1">
				<tr bgcolor="#9acd32">
					<th align="left">Title</th>
					<th align="left">Artist</th>
					<th align="left">Price</th>
				</tr>

				<!-- iterator only show books which cheaper than $10 -->
				<xsl:for-each select="catalog/cd[price &lt; 10]">
					<xsl:sort select="artist"/>  <!-- can sort the result -->
					<xsl:if test="price &gt; 8"> <!-- show books expensiver than $8 -->
						<tr>
							<td><xsl:value-of select="title"/></td>
							<td><xsl:value-of select="artist"/></td>
							<xsl:choose>         <!-- muti choose condition -->
								<xsl:when test="price = 9.90">
									<td align="right" bgcolor="#FF00FF" ><xsl:value-of select="price"/></td>
								</xsl:when>
								<xsl:when test="price = 8.90">
									<td align="right" bgcolor="#CCCCCC" ><xsl:value-of select="price"/></td>
								</xsl:when>
								<xsl:otherwise>
									<td align="right"><xsl:value-of select="price"/></td>
								</xsl:otherwise>
							</xsl:choose>
						</tr>
					</xsl:if>
				</xsl:for-each>
			</table>
		</body>
	</html>
</xsl:template>

</xsl:stylesheet>
