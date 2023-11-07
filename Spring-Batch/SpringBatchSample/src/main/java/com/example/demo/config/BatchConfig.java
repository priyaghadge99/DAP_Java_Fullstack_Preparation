package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@EnableBatchProcessing
@Configuration
@AllArgsConstructor
@NoArgsConstructor

public class BatchConfig {

//	@SuppressWarnings("removal")
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//	@SuppressWarnings("removal")
//	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private CustomerRepository repository;
	
	



	@Bean
	public FlatFileItemReader<CustomerEntity> reader() {
		FlatFileItemReader filereader = new FlatFileItemReader();
		filereader.setResource(new FileSystemResource("src/main/resources/customer.csv"));
		filereader.setName("csvreader");
		filereader.setLinesToSkip(1);
		filereader.setLineMapper(linemapper());
		return filereader;

	}

	@Bean
	public LineMapper<CustomerEntity> linemapper() {
		DefaultLineMapper<CustomerEntity> lineMapper = new DefaultLineMapper<>();
        //extract value from csv file
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("Id", "FirstName", "LastName", "Income", "Loss", "Additional", "quantity", "Location",
				"Type");
		
		//map csv file to the customer obj
		BeanWrapperFieldSetMapper<CustomerEntity> fieldMapper = new BeanWrapperFieldSetMapper<>();
		fieldMapper.setTargetType(CustomerEntity.class);
		
       lineMapper.setFieldSetMapper(fieldMapper);
       lineMapper.setLineTokenizer(lineTokenizer);
		return lineMapper;

	}
	
	@Bean
	public CustomerProcesser processer(){
		return new CustomerProcesser();
	}
	
	
	@Bean
	public RepositoryItemWriter<CustomerEntity> itemWriters(){
		
		RepositoryItemWriter itemWriter = new RepositoryItemWriter<>();
		itemWriter.setRepository(repository);
		itemWriter.setMethodName("save"); //save method to used 
		return itemWriter;
	}

	@SuppressWarnings({ "removal", "deprecation" })
	@Bean
	public Step step1(FlatFileItemReader<CustomerEntity> reader , CustomerProcesser  processor, RepositoryItemWriter<CustomerEntity> writer , JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("myStep",jobRepository)
        .<CustomerEntity, CustomerEntity>chunk(10,transactionManager)
        .reader(reader)
        .processor(processor)
        .writer(writer)
        .build();
		 
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public Job job1(Step step, JobRepository jobRepository) {
		return new JobBuilder("myJob",jobRepository)
	            .incrementer(new RunIdIncrementer())
	            .flow(step)
	            .end()
	            .build();
				
//				jobBuilderFactory.get("importCustomers")
//				.flow(step1()).end().build();
	}
	
	
}
