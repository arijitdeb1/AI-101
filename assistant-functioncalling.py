import time
from openai import OpenAI

#Initialize the Client
client = openai.OpenAI()


# Step 1: Create an Assistant
assistant = client.beta.assistants.create(

)