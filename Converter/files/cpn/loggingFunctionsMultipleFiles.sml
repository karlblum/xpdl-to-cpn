

fun calculateTimeStamp() = 
let
	val curtimeint = IntInf.toLarge(time())*60;
	val curtime = SMLTime.fromSeconds(curtimeint);
	val curdate = Date.fromTimeLocal(curtime);
	val timestamp = (Date.fmt "%Y-%m-%dT%H:%M" curdate);

in
	timestamp^":"^"00.000+01:00"
end;



fun writeTimeStamp(file_id, timestamp) = 
let
	val _ = TextIO.output(file_id, "<Timestamp>")
	val _ = TextIO.output(file_id, timestamp)


in
	TextIO.output(file_id, "</Timestamp>\n")
end;



fun writeWorkflowModelElement(file_id, workflowModelElement) = 
let
	val _ = TextIO.output(file_id, "<WorkflowModelElement>")
	val _ = TextIO.output(file_id, workflowModelElement)


in
	TextIO.output(file_id, "</WorkflowModelElement>\n")
end;


fun getDescription(description) = 
	if length(description) = 0
	then ""
	else hd(description)


fun getComplement(event, description) = 
let
	val desc = getDescription(description)
	val complement = "unknowntype=\"" ^ desc ^ "\""
in
	if event = "unknown"
	then  complement
	else  ""
end;


fun writeEventType(file_id, event :: description) = 
let

	val complement = getComplement(event, description)
	val _ = TextIO.output(file_id, "<EventType ")
	val _ = TextIO.output(file_id, complement)
	val _ = TextIO.output(file_id, ">")		
	val _ = TextIO.output(file_id, event)

in
	TextIO.output(file_id, "</EventType>\n")
end;



fun writeOriginator(file_id, Originator) = 
let
	val _ = TextIO.output(file_id, "<Originator>")
	val _ = TextIO.output(file_id, Originator)

in
	TextIO.output(file_id, "</Originator>\n")
end;


fun writeDataAttributes(nil) = " "
| writeDataAttributes(name::nil) =  "<Attribute name = \"" ^ name ^ "\"> </Attribute>\n" 
| writeDataAttributes(name::value::tail) = "<Attribute name = \"" ^ name ^ "\">" ^value ^" </Attribute>\n" ^ writeDataAttributes(tail) 

fun writeData(file_id, data) = 
let
	val _ = TextIO.output(file_id, "<Data>")
	val _ = TextIO.output(file_id, writeDataAttributes(data))
in
	TextIO.output(file_id, "</Data>")
end;	  

fun  testWriteData (file_id, data) = 
	if length(data) = 0
	then TextIO.output(file_id, "")
	else writeData(file_id, data)

fun add (file_id, workflowModelElement, EventType, TimeStamp, Originator, Data)=
let
	val _ = TextIO.output(file_id, "<AuditTrailEntry>\n")
	val _ = testWriteData(file_id, Data)
	val _ = writeWorkflowModelElement(file_id, workflowModelElement)
	val _ = writeEventType(file_id, EventType)
	val _ = writeTimeStamp(file_id, TimeStamp)
	val _ = writeOriginator(file_id, Originator)
	val _ = TextIO.output(file_id, "</AuditTrailEntry>\n")

in
	TextIO.closeOut(file_id)
end;



fun addATE (caseID,workflowModelElement, EventType, TimeStamp, Originator, Data) = 
let
	val file_id = TextIO.openAppend(FILE^Int.toString(caseID)^FILE_EXTENSION)
in
	add(file_id, workflowModelElement, EventType, TimeStamp, Originator, Data)
end;

fun createCaseFile(caseID) = 
let
   val caseIDString = Int.toString(caseID)
   val file_id = TextIO.openOut(FILE ^ caseIDString  ^ FILE_EXTENSION)
   val _ = TextIO.output(file_id, caseIDString  ^ "\n")
in
   TextIO.closeOut(file_id)
end;


