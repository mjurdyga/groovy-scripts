import com.atlassian.jira.component.ComponentAccessor

def customFieldManager = ComponentAccessor.getCustomFieldManager()
def optionsManager = ComponentAccessor.getOptionsManager()

//def cfield = getFieldByName("Request Type")

def cfield = getFieldById("customfield_10237")
Map mapValue = cfield.getValue() as Map
def value1 = mapValue.get(0).toString()
def value2 = mapValue.get(0).toString()


//def formField = getFieldByName("Operating Sysaa") // *name* of your custom field
//def SourceField = getFieldByName("Operating Sys") // *source
//def customField = customFieldManager.getCustomFieldObject(formField.getFieldId())

def desc = getFieldById("description")

if (value1 == 'Jira'){

def defaultValue = """h2. Jira
    * Jira 1
    * Jira 2
    h2. Jira Expected Result
    The widget should appear
    h2. Actual Result
    The widget doesn't appear""".replaceAll(/    /, '')

if (!underlyingIssue?.description) { 
    desc.setFormValue(defaultValue)
}}

else if (value1 == 'Confluence')
{
def defaultValue = """h2. Confluence
    * Confluence 1
    * Confluence 2
    h2. Confluence Expected Result
    The widget should appear
    """.replaceAll(/    /, '')
if (!underlyingIssue?.description) { 
    desc.setFormValue(defaultValue)
}}
