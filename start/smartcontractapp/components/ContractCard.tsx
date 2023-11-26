import { MediaRenderer, useContract, useContractMetadata } from '@thirdweb-dev/react'
import styles from '../styles/Home.module.css'
import Link from 'next/link'
type CardProps={
    href:string,
    contractAddress:string,
    title:string,
    description:string
}


const ContractCard = (props:CardProps) => {
  const {contract}=useContract(props.contractAddress)
  const {data:contractMetadata,isLoading:isContractMetadata}=useContractMetadata(contract)
  return (
    <Link href={props.href} className={styles.card}>
      <MediaRenderer src={contractMetadata?.image} width='100%' height='auto'/>
      <div className={styles.cardText}>
        <h2 className={styles.gradientText1}>{props.title}</h2>
        <p>{props.description}</p>
      </div>
    </Link>
  )
}

export default ContractCard