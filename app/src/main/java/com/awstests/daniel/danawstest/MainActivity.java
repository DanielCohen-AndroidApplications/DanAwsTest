package com.awstests.daniel.danawstest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.auth.policy.actions.DynamoDBv2Actions;
import com.amazonaws.auth.policy.conditions.StringCondition;
import com.amazonaws.mobileconnectors.cognito.CognitoSyncManager;
import com.amazonaws.mobileconnectors.cognito.Dataset;
import com.amazonaws.mobileconnectors.cognito.DefaultSyncCallback;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.mobileconnectors.*;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Daniel on 5/19/2016.
 */
public class MainActivity extends Activity {
    TextView textView;
    EditText editTextUserId, editTextSalary, editTextAge, editTextLocation;
    Button buttonSend, buttonReceive;
    String inputUserId, outputUserId;
    AmazonDynamoDB dynamoDB;
    PutItemRequest putItemRequest;
    Map<String,AttributeValue> mapRequest;
    AttributeValue attributeValue;


    private CognitoCachingCredentialsProvider credentialsProvider;

    Exception error;
    Boolean isError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dynamoDB=new AmazonDynamoDB() {
            @Override
            public void setEndpoint(String endpoint) throws IllegalArgumentException {

            }

            @Override
            public void setRegion(Region region) throws IllegalArgumentException {

            }

            @Override
            public CreateTableResult createTable(CreateTableRequest createTableRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public ScanResult scan(ScanRequest scanRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public DescribeLimitsResult describeLimits(DescribeLimitsRequest describeLimitsRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public BatchGetItemResult batchGetItem(BatchGetItemRequest batchGetItemRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public GetItemResult getItem(GetItemRequest getItemRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public ListTablesResult listTables(ListTablesRequest listTablesRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public BatchWriteItemResult batchWriteItem(BatchWriteItemRequest batchWriteItemRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public DeleteTableResult deleteTable(DeleteTableRequest deleteTableRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public DeleteItemResult deleteItem(DeleteItemRequest deleteItemRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public UpdateTableResult updateTable(UpdateTableRequest updateTableRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public UpdateItemResult updateItem(UpdateItemRequest updateItemRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public DescribeTableResult describeTable(DescribeTableRequest describeTableRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public QueryResult query(QueryRequest queryRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public PutItemResult putItem(PutItemRequest putItemRequest) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public DescribeLimitsResult describeLimits() throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public ListTablesResult listTables() throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public CreateTableResult createTable(List<AttributeDefinition> attributeDefinitions, String tableName, List<KeySchemaElement> keySchema, ProvisionedThroughput provisionedThroughput) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public ScanResult scan(String tableName, List<String> attributesToGet) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public ScanResult scan(String tableName, Map<String, Condition> scanFilter) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public ScanResult scan(String tableName, List<String> attributesToGet, Map<String, Condition> scanFilter) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> requestItems, String returnConsumedCapacity) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> requestItems) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public GetItemResult getItem(String tableName, Map<String, AttributeValue> key) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public GetItemResult getItem(String tableName, Map<String, AttributeValue> key, Boolean consistentRead) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public ListTablesResult listTables(String exclusiveStartTableName) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public ListTablesResult listTables(String exclusiveStartTableName, Integer limit) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public ListTablesResult listTables(Integer limit) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public BatchWriteItemResult batchWriteItem(Map<String, List<WriteRequest>> requestItems) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public DeleteTableResult deleteTable(String tableName) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public DeleteItemResult deleteItem(String tableName, Map<String, AttributeValue> key) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public DeleteItemResult deleteItem(String tableName, Map<String, AttributeValue> key, String returnValues) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public UpdateTableResult updateTable(String tableName, ProvisionedThroughput provisionedThroughput) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public UpdateItemResult updateItem(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public UpdateItemResult updateItem(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates, String returnValues) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public DescribeTableResult describeTable(String tableName) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public PutItemResult putItem(String tableName, Map<String, AttributeValue> item) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public PutItemResult putItem(String tableName, Map<String, AttributeValue> item, String returnValues) throws AmazonServiceException, AmazonClientException {
                return null;
            }

            @Override
            public void shutdown() {

            }

            @Override
            public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
                return null;
            }
        };




        textView=(TextView) findViewById(R.id.textView);
        editTextUserId=(EditText) findViewById(R.id.editTextUserId);
        editTextSalary=(EditText) findViewById(R.id.editTextSalary);
        editTextAge=(EditText) findViewById(R.id.editTextAge);
        editTextLocation=(EditText) findViewById(R.id.editTextLocation);
        buttonReceive=(Button) findViewById(R.id.buttonReceive);
        buttonSend=(Button) findViewById(R.id.buttonSend);

        credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "us-east-1:ceae0626-1082-4759-85c3-fae01752889a", // Identity Pool ID
                Regions.US_EAST_1 // Region
        );
        CognitoSyncManager syncClient = new CognitoSyncManager(
                getApplicationContext(),
                Regions.US_EAST_1, // Region
                credentialsProvider);

// Create a record in a dataset and synchronize with the server
        Dataset dataset = syncClient.openOrCreateDataset("myDataset");
        dataset.put("name", "dan");
        dataset.put("age", "26");
        dataset.synchronize(new DefaultSyncCallback() {
            @Override
            public void onSuccess(Dataset dataset, List newRecords) {
                //Your handler code here
            }
        });
    }
    public void sendString(View view){
        new dataTask().execute();
    }
    public void receiveString(View view){
        outputUserId=editTextUserId.getText().toString();

    }
    public class dataTask extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... params) {
            try {
                putItemRequest=new PutItemRequest();
                putItemRequest.setTableName("Music");

                attributeValue=new AttributeValue();
                attributeValue.setS("GD");
                mapRequest.put("Artist", attributeValue);
                putItemRequest.setItem(mapRequest);
            }catch (Exception e){

            }
//            try {
//// Initialize the Cognito Sync client
////                CognitoSyncManager syncClient = new CognitoSyncManager(
////                        getApplicationContext(),
////                        Regions.US_EAST_1, // Region
////                        credentialsProvider);
////
////// Create a record in a dataset and synchronize with the server
////                Dataset dataset = syncClient.openOrCreateDataset("myDataset");
////                dataset.put("myKey", "myValue");
////                dataset.synchronize(new DefaultSyncCallback() {
////                    @Override
////                    public void onSuccess(Dataset dataset, List newRecords) {
////                        //Your handler code here
////                    }
////                });
//            }catch (Exception e){
//                isError=true;
//                error=e;
//            }
            return "Executed";
        }
    }
}
