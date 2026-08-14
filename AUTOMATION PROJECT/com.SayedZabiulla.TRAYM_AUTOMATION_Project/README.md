# TRYAM Lead Qualification & CRM Router

## Overview

This project is an end-to-end AI-powered lead qualification workflow built in **n8n** for the TRYAM Automations Technical Assessment.

The workflow receives customer inquiries through a webhook, uses **Google Gemini** to evaluate the lead, assigns a lead score, and routes the lead based on the score.

## Features

- Webhook-based lead intake
- AI lead scoring using Google Gemini
- Industry classification
- High-priority leads saved to Google Sheets
- Low-priority leads receive an automated Gmail follow-up
- Validation for missing required fields
- Error response with HTTP 400 for invalid requests

## Workflow

```text
Webhook
   │
   ▼
Required Field Validation (IF)
   ├── False → Respond to Webhook (400 Error)
   └── True
         │
         ▼
   Google Gemini (AI Lead Scoring)
         │
         ▼
   Lead Score Check (IF)
      ├── Score ≥ 7 → Google Sheets
      └── Score < 7 → Gmail Follow-up
```

## Technologies Used

- n8n
- Google Gemini API
- Google Sheets API
- Gmail API

## Input Format

```json
{
  "name": "John Doe",
  "email": "john@company.com",
  "budget": 5000,
  "companySize": 50,
  "projectDescription": "Need an AI chatbot"
}
```

## AI Output

```json
{
  "leadScore": 7,
  "industry": "Technology",
  "reason": "Strong alignment with project requirements."
}
```

## Test Cases

### High Priority

- Budget: High
- Company Size: Large
- Expected Result:
  - Google Sheets entry created

### Low Priority

- Budget: Low
- Company Size: Small
- Expected Result:
  - Gmail follow-up sent

### Missing Required Field

Request without `name`.

Expected Response:

```json
{
  "error": "Missing required fields"
}
```

Status Code: **400 Bad Request**

## Project Structure

```text
TRAYM_AUTOMATION_Project/
│
├── workflow/
│   └── TRYAM_Lead_Router.json
│
├── README.md
└── demo/
    └── Demo Video
```

## Deliverables

- n8n Workflow (`TRYAM_Lead_Router.json`)
- 2–3 minute demo video
- Publicly accessible video link