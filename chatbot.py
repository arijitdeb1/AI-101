import streamlit as st
from PyPDF2 import PdfReader 
from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain.embeddings.openai import OpenAIEmbeddings
from langchain.vectorstores import FAISS
from langchain.chains.question_answering import load_qa_chain
from langchain_community.chat_models import ChatOpenAI


OPEN_AI_API_KEY = # get your openai api key from https://platform.openai.com/account/api-keys

#Upload PDF files
st.header("My ChatBot")

with st.sidebar:
    st.title("Your Documents")
    file = st.file_uploader("Upload PDF file and start asking questions", type="pdf")

#Extract text from PDF
if file is not None:
    reader = PdfReader(file)
    text = ""
    for page in reader.pages:
        text += page.extract_text()
    #st.write(text)

    # Break the text into chunks
    text_splitter = RecursiveCharacterTextSplitter(    
        separators="\n",
        chunk_size=1000,
        chunk_overlap=150,
        length_function=len
    )
    chunks = text_splitter.split_text(text)
    # st.write(chunks)

    # Generate embeddings
    embeddings = OpenAIEmbeddings(openai_api_key=OPEN_AI_API_KEY)

    # Creating Vector Store - FAISS(Facebook AI Symentic Search)
    vector_store = FAISS.from_texts(chunks, embeddings)

    # Ask questions
    question = st.text_input("Ask a question")

    # Do similarity search
    if question:
        match = vector_store.similarity_search(question) # match will contain the most similar chunk matching with the question
        #st.write(match)

        # Define the LLM
        llm = ChatOpenAI(
            openai_api_key=OPEN_AI_API_KEY,
            temperature= 0,
            max_tokens=1000,
            model_name="gpt-3.5-turbo"           
        )

        # Load the QA chain to LLM
        # chain -> take the question, get relevant document, pass it to LLM, generate the output
        chain = load_qa_chain(llm, chain_type="stuff")
        response = chain.run(input_documents = match, question = question)
        st.write(response)

