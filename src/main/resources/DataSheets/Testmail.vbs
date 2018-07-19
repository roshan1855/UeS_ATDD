'test
dim objOutlk	'Outlook
dim objMail	'Email item
name = WScript.Arguments.Item(0)

dim strMsg
const olMailItem = 0
'Create a new message
	set objOutlk = createobject("Outlook.Application")
	set objMail = objOutlk.createitem(olMailItem)
	objMail.To = "harleen_kaur11@optum.com"
	'objMail.cc = "" 'Enter an address here to include a carbon copy; bcc is for blind carbon copy's
'Set up Subject Line
	objMail.subject = "I saw your code on Planet Source Code on " & cstr(month(now)) & "/" & cstr(day(now)) & "/" & cstr(year(now))
'Add the body
	
	strMsg = "Your code rocks!" & vbcrlf & name
	'strMsg = strMsg & "I voted and gave you an excellent rating!"
'To add an attachment, use:
	'objMail.attachments.add("C:\MyAttachmentFile.txt")
	objMail.body = strMsg
	objMail.display 'Use this to display before sending, otherwise call objMail.Send to send without reviewing
	objMail.Send 'Let´s go!

'Clean up
set objMail = nothing
set objOutlk = nothing
