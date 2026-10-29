$htmlPath = "c:\Users\PankajGhosh\eclipse-workspace\MESH\MESH_Automation_Framework_Portfolio_Summary.html"
$docxPath = "c:\Users\PankajGhosh\eclipse-workspace\MESH\MESH_Automation_Framework_Portfolio_Summary.docx"

# Create Word application object
$word = New-Object -ComObject Word.Application
$word.Visible = $false

# Open the HTML file
$doc = $word.Documents.Open($htmlPath)

# Save as DOCX
$doc.SaveAs($docxPath, 12)

# Close Word
$word.Quit()

Write-Host "Word document created successfully at: $docxPath"
