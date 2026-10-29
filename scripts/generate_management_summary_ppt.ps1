$ErrorActionPreference = 'Stop'

$outputPath = "c:\Users\PankajGhosh\eclipse-workspace\MESH\reports\MESH_Executive_Summary_2026-06-16.pptx"

$powerPoint = New-Object -ComObject PowerPoint.Application
$powerPoint.Visible = -1
$presentation = $powerPoint.Presentations.Add()

function Add-TitleSlide {
    param(
        [object]$deck,
        [string]$title,
        [string]$subtitle
    )

    $slide = $deck.Slides.Add($deck.Slides.Count + 1, 1)
    $slide.Shapes.Title.TextFrame.TextRange.Text = $title
    $slide.Shapes.Item(2).TextFrame.TextRange.Text = $subtitle
    return $slide
}

function Add-BulletSlide {
    param(
        [object]$deck,
        [string]$title,
        [string[]]$bullets
    )

    $slide = $deck.Slides.Add($deck.Slides.Count + 1, 2)
    $slide.Shapes.Title.TextFrame.TextRange.Text = $title

    $text = [string]::Join("`r`n", $bullets)
    $slide.Shapes.Item(2).TextFrame.TextRange.Text = $text

    $range = $slide.Shapes.Item(2).TextFrame.TextRange
    for ($i = 1; $i -le $range.Paragraphs().Count; $i++) {
        $range.Paragraphs($i).ParagraphFormat.Bullet.Visible = $true
    }

    return $slide
}

function Add-TwoColumnSlide {
    param(
        [object]$deck,
        [string]$title,
        [string[]]$leftItems,
        [string[]]$rightItems,
        [string]$leftHeader,
        [string]$rightHeader
    )

    $slide = $deck.Slides.Add($deck.Slides.Count + 1, 2)
    $slide.Shapes.Title.TextFrame.TextRange.Text = $title

    $body = $slide.Shapes.Item(2)
    $bodyText = $leftHeader + "`r`n" + [string]::Join("`r`n", $leftItems) + "`r`n`r`n" + $rightHeader + "`r`n" + [string]::Join("`r`n", $rightItems)
    $body.TextFrame.TextRange.Text = $bodyText

    $range = $body.TextFrame.TextRange
    $paragraphCount = $range.Paragraphs().Count
    $secondHeaderIndex = 2 + $leftItems.Count + 1
    for ($i = 1; $i -le $paragraphCount; $i++) {
        if ($i -eq 1 -or $i -eq $secondHeaderIndex) {
            $range.Paragraphs($i).ParagraphFormat.Bullet.Visible = $false
        } elseif ($range.Paragraphs($i).Text.Trim().Length -eq 0) {
            $range.Paragraphs($i).ParagraphFormat.Bullet.Visible = $false
        } else {
            $range.Paragraphs($i).ParagraphFormat.Bullet.Visible = $true
        }
    }

    return $slide
}

Add-TitleSlide -deck $presentation -title "MESH Automation Program Summary" -subtitle "Executive Brief | Generated: 2026-06-16"

Add-BulletSlide -deck $presentation -title "Leadership Snapshot" -bullets @(
    "Purpose: Salesforce automation suite validating Decision Package and Escalation workflows",
    "Footprint: 26 Java classes (18 framework + 8 test classes)",
    "Coverage: 34 automated TestNG scenarios across critical business flows",
    "Execution Evidence: 101 timestamped run folders in reports with recurring daily runs",
    "Latest TestNG snapshot: 7/7 tests passed, 0 failed, 0 skipped"
)

Add-BulletSlide -deck $presentation -title "Business Workflows Automated" -bullets @(
    "Decision Package lifecycle: create, validate, review, approve, issue",
    "Escalation Tracking lifecycle: create, assign, monitor, return, resolve",
    "Cross-role orchestration: State Officer, Deputy Director, FM Reviewer, Division Director",
    "Notification checks: email validations during status transitions",
    "Document operations: file upload, download, and related package artifacts"
)

Add-TwoColumnSlide -deck $presentation -title "Architecture And Stack" `
    -leftHeader "Current Stack" `
    -leftItems @(
        "Java 8 target via Maven",
        "Selenium 4.27 + TestNG 7.4",
        "ExtentReports 5.1.2",
        "Config via properties and dotenv",
        "Chrome WebDriver local execution"
    ) `
    -rightHeader "Execution Model" `
    -rightItems @(
        "Profile Mesh_Suite_One: Decision Package suite",
        "Profile Mesh_Suite_Two: Escalation suite",
        "XML suite orchestration under src/test/resources/XML_Suites",
        "Report output to reports/<timestamp>/testReport.html",
        "GitHub Actions pipeline uses JDK 17"
    )

Add-BulletSlide -deck $presentation -title "Delivery Metrics" -bullets @(
    "Main framework classes: 18",
    "Test classes: 8",
    "Automated tests (@Test methods): 34",
    "Historical execution folders: 101",
    "Latest suite runtime: ~23.7 minutes (1,420,344 ms)"
)

Add-TwoColumnSlide -deck $presentation -title "Strengths And Value" `
    -leftHeader "Program Strengths" `
    -leftItems @(
        "Strong page-object style separation across pages and locators",
        "Rich visual reporting with screenshot evidence",
        "Reusable action layer in SafeActions",
        "Covers multi-role business-critical scenarios",
        "Active usage indicated by high run frequency"
    ) `
    -rightHeader "Business Value Delivered" `
    -rightItems @(
        "Faster regression validation for release cycles",
        "Improved confidence on workflow transitions",
        "Reduced manual testing effort on complex flows",
        "Early defect detection in Salesforce UI process changes",
        "Audit-friendly execution evidence via reports"
    )

Add-BulletSlide -deck $presentation -title "Top Risks For Management" -bullets @(
    "Security risk: plaintext credentials file present in workspace (.env)",
    "Technology risk: Java 8 target is legacy while CI uses JDK 17",
    "Stability risk: frequent fixed sleeps increase flaky behavior potential",
    "Maintainability risk: brittle XPath-heavy locators vulnerable to UI changes",
    "Operational risk: report and screenshot sprawl (101 folders) without retention policy"
)

Add-BulletSlide -deck $presentation -title "90-Day Modernization Plan" -bullets @(
    "Weeks 1-2: secure credentials, remove secrets from repo, enforce secret scanning",
    "Weeks 2-4: align runtime to Java 17 and refresh dependency baseline",
    "Weeks 4-8: replace fixed waits with robust explicit waits and retry analyzer",
    "Weeks 6-10: locator hardening and page object cleanup for resilience",
    "Weeks 8-12: artifact retention policy + CI quality dashboard rollout"
)

Add-TwoColumnSlide -deck $presentation -title "Investment Priorities" `
    -leftHeader "High Impact / Low To Medium Effort" `
    -leftItems @(
        "Credential hardening and secret management",
        "Java and dependency upgrade",
        "Flakiness reduction (wait strategy + retries)"
    ) `
    -rightHeader "Medium Effort Strategic Improvements" `
    -rightItems @(
        "Locator modernization and UI stability layer",
        "Data-driven test strategy",
        "Centralized reporting and trend analytics"
    )

Add-BulletSlide -deck $presentation -title "Executive Decision Ask" -bullets @(
    "Approve a focused 2-sprint stabilization and security modernization initiative",
    "Nominate QA + Dev owner pair for framework modernization execution",
    "Track KPI targets: flakiness reduction, run success rate, and mean triage time",
    "Institutionalize monthly automation health review with leadership visibility"
)

$presentation.SaveAs($outputPath)
$presentation.Close()
$powerPoint.Quit()

[System.Runtime.Interopservices.Marshal]::ReleaseComObject($presentation) | Out-Null
[System.Runtime.Interopservices.Marshal]::ReleaseComObject($powerPoint) | Out-Null

Write-Output "PPT generated: $outputPath"
