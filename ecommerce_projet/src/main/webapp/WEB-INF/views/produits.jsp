<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css"/>
</head>
<div class="errors">
  ${exception} 
</div>
<div id="formProd" class="cadre">

	<f:form modelAttribute="produit" action="saveProd" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID Produit</td>
				<td><f:input path="idProduit" /></td>
				<td><f:errors path="idProduit" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Désignation</td>
				<td><f:input path="designation" /></td>
				<td><f:errors path="designation" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Catégorie</td>
				<td><f:select path="categorie.idCategorie" items="${categories}"
				 itemValue="idCategorie" itemLabel="nomCategorie"/></td>
				<td><f:errors path="categorie.nomCategorie" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><f:textarea path="description" /></td>
				<td><f:errors path="description" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Prix</td>
				<td><f:input path="prix" /></td>
				<td><f:errors path="prix" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Quantité</td>
				<td><f:input path="quantite" /></td>
				<td><f:errors path="quantite" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Selectionner</td>
				<td><f:checkbox path="selected" /></td>
				<td><f:errors path="selected" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Photo</td>
				<td>
				<c:if test="${produit.idProduit!=null}">
					<img src="photoProd?idProd=${produit.idProduit}"/>
				</c:if>
				</td>
				<td><input type="file" name="file" /></td>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</f:form>
</div>
<div id="tabProduits" class="cadre">
	<table class="tab1">
		<tr>
			<th>ID</th><th>DESIGNATION</th><th>DESCRIPTION</th><th>CATEGORIE</th>
			<th>PRIX</th><th>QUANTITE</th><th>SELECTED</th><th>PHOTO</th>
		</tr>
		<c:forEach items="${produits}" var="p">
			<tr>
				<td>${p.idProduit}</td>
				<td>${p.designation}</td>
				<td>${p.description}</td>
				<td>${p.categorie.nomCategorie}</td>
				<td>${p.prix}</td>
				<td>${p.quantite}</td>
				<td>${p.selected}</td>
				<td><img src="photoProd?idProd=${p.idProduit}" /></td>
				<td><a href="suppProd?idProd=${p.idProduit}">Supprimer</a></td>
				<td><a href="editProd?idProd=${p.idProduit}">Editer</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
