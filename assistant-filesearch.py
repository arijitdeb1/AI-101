import time
from openai import OpenAI

# id of AI Assistant
ID = "asst_ooWBKg9oU1kC97kVHD9GMUYM"

# provide the api key
client=OpenAI(api_key="-----Use API Key here-----")

# create a new Thread for this conversation
chat = client.beta.threads.create(
   messages = [
    {
        "role": "user",
        "content": "What was the temperature in Delhi on 1st May 2024?" # Your prompt here
    },
    {
      "role": "user",
      "content": "What was the average temperature of Mumbai from 1st May 2024 to 3rd May 2024?" # Your prompt here  
    }
   ]
)

run = client.beta.threads.runs.create(thread_id=chat.id, assistant_id=ID)
print(f" Run Created: {run.id}")

while run.status != "completed":
    run = client.beta.threads.runs.retrieve(thread_id=chat.id, run_id=run.id)
    print(f" Run Status : {run.status}")
    time.sleep(0.5) # wait for 30 seconds
else:
    print(f" Run Completed! ")

# fetch the response
message_response = client.beta.threads.messages.list(thread_id=chat.id)
messages = message_response.data

latest_message = messages[0]
print(f" Response: {latest_message.content[0].text.value}")